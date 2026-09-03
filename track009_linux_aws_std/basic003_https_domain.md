■Step4. HTTPS + DOMAIN

1. DuckDns 도메인 생성
1) https://www.duckdns.org
2) 로그인
3) SUB DOMAIN -> 원하는이름.duckdns.org -> add domain
4) ec2 public ip 연동
5) Token
```
 the703yj.duckdns.org
```

2. EC2 서버에서 DuckDns IP 자동 갱신설정
    > Aws Ec2의 인스턴스를 중지했다키면, 퍼블릭 ip 주소가 바뀜

    1) ssh 접속
    2) duckdns 폴더 만들기
    ```bash
    sudo mkdir  -p ~/duckdns
    cd ~/duckdns
    ```
    3) duck.sh 쉘스크립트 작성
    ```bash
    sudo  vi  duck.sh
    esc   , i
    esc   , :wq!
    ```

    ```bash
    echo url="https://www.duckdns.org/update?domains=도메인명&token=복사해둔토큰&ip=" | curl -k -o ~/duckdns/duck.log -K -

    echo url="https://www.duckdns.org/update?domains=the703yj.duckdns.org&token=5b07ce32-c00f-49e7-9996-683ddff03b6d&ip=" | curl -k -o ~/duckdns/duck.log -K -
    ```
    ※ -k : ssl/tls 인증서 건너뛰기
    ※ -o ~/duckdns/duck.log -k - : 성공 ok, 실패시 ko
    ※ -k 표준입력의 설정 ,,,,, 코드중간에  |  

    4) 실행권한주기  소유자 모든권한, 그룹x, 다른x
    ```sql
    sudo chmod  700  duck.sh
    crontab -e
    2

    */5 * * * *   /home/ubuntu/duckdns/duck.sh >/dev/null  2>&1

    # */5 * * * *   년 [월일 시분<-] 초 
    분 시 일 월 요일

    # >/dev/null  
    # 

    crontab -1
    ```


3. Nginx 설정변경
 2-1.
  ```
  sudo vi   /etc/nginx/sites-available/default
  ```

  2-2. esc 눌러서 명령모드로 전환 
  2-3. :%d 입력한뒤에 enter → 전체삭제
  2-4. i 눌러서 입력모드전환  →  붙여넣기
  2-5. esc   →  :wq!  저장후 종료
  ```


  server {
      listen 80;
      server_name the703yj.duckdns.org;

      # 프론트엔드 (Next.js SSR 서버)
      location / {
          proxy_pass http://localhost:3000;
          proxy_http_version 1.1;
          proxy_set_header Upgrade $http_upgrade;
          proxy_set_header Connection "upgrade";
          proxy_set_header Host $host;
          proxy_cache_bypass $http_upgrade;
          proxy_set_header Cookie $http_cookie; 
      }

      # 백엔드 - 유저 인증 (/auth)
      location /auth {
          proxy_pass http://localhost:8080;
          proxy_http_version 1.1;
          proxy_set_header Host $host;
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_set_header X-Forwarded-Proto $scheme;
          proxy_set_header Cookie $http_cookie;
      }

      # 백엔드 - 일반 API (/api)
      location /api {
          proxy_pass http://localhost:8080;
          proxy_http_version 1.1;
          proxy_set_header Host $host;
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_set_header X-Forwarded-Proto $scheme;
          proxy_set_header Cookie $http_cookie;
      }

      # 백엔드 - 소셜 로그인 (/oauth2)
      location /oauth2 {
          proxy_pass http://localhost:8080;
          proxy_http_version 1.1;
          proxy_set_header Host $host;
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_set_header X-Forwarded-Proto $scheme;
          proxy_set_header Cookie $http_cookie;
      }

      # 백엔드 - 카카오/구글 리다이렉트 처리
      location /login/oauth2/ {
          proxy_pass http://localhost:8080;
          proxy_http_version 1.1;
          proxy_set_header Host $host;
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_set_header X-Forwarded-Proto $scheme;
      }

      # 프론트엔드에서 처리해야 하는 콜백
      location /oauth2/callback {
          proxy_pass http://localhost:3000;
          proxy_set_header Host $host;
          proxy_set_header X-Real-IP $remote_addr;
          proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
          proxy_set_header X-Forwarded-Proto $scheme;
          proxy_set_header Cookie $http_cookie;
      }

      # 정적 파일 경로
      location /uploads/ {
          alias /home/ubuntu/app/back/build/libs/uploads/;
          autoindex off;
      }
  }
  ```
4. Cerbot으로 Https( SSL ) 인증서 발급받기
1) cerbot 설치
    ```bash
    sudo apt update
    sudo apt install snapd -y   # 격리된 환경
    sudo snap install core; 
    sudo snap refresh core
    sudo snap install --classic certbot   # SSL무료인증서 발급도구
    sudo ln -s /snap/bin/certbot /usr/bin/certbot # 터미널 어디에서든지 사용가능
    ```

2) 인증서 발급 명령어 실행
```bash
sudo certbot --nginx -d the703yj.duckdns.org
```

5.  프로젝트 환경변수 
> before :  http://43.201.154.243
> after  :  https://the703yj.duckdns.org

1) boot  : SecurityConfig, yml
2) react : .env

3. 소셜마무리
http://43.201.154.243