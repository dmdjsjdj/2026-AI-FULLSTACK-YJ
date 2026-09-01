## CI/CD
1. CI (Continuous Integration, 지속적 통합)
- 개발자들이 작성한 코드를 정기적으로 중앙저장소에 병합하고
- 자동으로 빌드 및 테스트 하는 과정
2. CD (Continuous Delivery / Continuous Deployment, 지속적 전달 및 배포)
- CI과정을 거친 코드를 프로덕션(실서비스) 환경에 배포할수 있도록 준비,
배포단계

## Part001. Linux
### 진행사항
1. Ubuntu 24.04 컨테이너 실행 방법
2. linux 사용자
3. 기본명령어
4. 파일
5. 유저
6. job + 쉘스크립트

#### 1. Ubuntu 24.04 컨테이너 실행 방법
- 도커 : 컨테이너 기반의 가상화 플랫폼

1. 이미지 다운로드
```bash
docker pull ubuntu:24.04
```

2. 컨테이너 실행 (run)
```bash
docker run -it --name myubuntu ubuntu:24.04 bash
```
1) -it : -i(표준입력 Interactive), -t(터미널 Pseudo-TTY)
2) --name myubuntu : 컨테이너 이름 지정
3) ubuntu:24.04 : 이미지 이름 및 태그(버전)
4) bash : 컨테이너 내부에서 실행할 쉘 전달 및 배포)

3. 컨테이너 내부에서 패키지업데이트 및 필수 패키지 일괄설치
```
apt update && apt upgrade -y && DEBIAN_FRONTEND=noninteractive apt install -y vim man-db 
net-tools iproute2 adduser sudo
```
1) apt update: 설치 가능한 패키지 목록을 최신 상태로 업데이트합니다.
2) &&: 앞의 명령어가 성공적으로 끝나면 뒤의 명령어를 연속해서 실행합니다.
3) apt upgrade -y: 설치되어 있는 모든 프로그램을 최신 버전으로 업그레이드합니다. (-y는 확인 질문에 자동으로 Yes 응답)
4) DEBIAN_FRONTEND=noninteractive: 패키지 설치 중 대국민 설문 형태(시간대 설정 등)의 키보드 입력을 요구하는 팝업 창을 띄우지 않고 기본값으로 자동 진행하게 만듭니다. (도커 컨테이너 환경에서 설치가 중간에 멈추는 것을 방지하는 핵심 설정)
5) apt install -y ...: 지정한 패키지들을 자동으로 설치합니다.


4. 컨테이너 종료 후 다시 실행 ( ps 상태확인 / start 실행 )
```bash
docker ps -a
```
```bash
docker start -ai myubuntu
```
-a : 터미널 실시간 화면 보이기
-i : 키보드 입력


## 1) docker
1) 이미지 다운로드 - docker pull
2) 이미지 컨테이너 만들고 실행 - docker run
3) 도커확인 - docker ps
4) 실행 - docker start

#### 2. linux 사용자
1. # : root 사용자 (최고 관리자)
2. $ : 일반 사용자 (일반계정 관리자)
   ※ AWS EC2에서 sudo 명령을 붙여서 실행

#### 3. 기본명령어
```
#1. 날짜 확인
date

#2. 출력
echo hello

#3. 명령어 위치 확인
which date

#4. 명령어 설명서 (매뉴얼)
man date
```

```bash
#man 명령어가 작동하지 않거나 최소화된 매뉴얼 복원
apt update    # 패키지 최신상태
apt install -y man-db manpages # 설치, 조회도구, 기본명령어 매뉴얼
yes | unminimize
```
```bash
man date
↑ ↓  q (빠져나오기)

date
date  "+%Y-%m-%d"
```

Q1. hi 출력
Q2. man이용해서 echo 확인

```
root@acfec9bff0f5:/# echo hi
hi
root@acfec9bff0f5:/# man echo
ECHO(1)                                                    User Commands                                                   E
CHO(1)
q   # 빠져나오기
```

## ■정리 2) 기본
1) 날짜 date
2) 출력 echo
3) 위치 which
4) 매뉴얼 man


#### 4. 파일

1) 파일 및 디렉토리 생성
```bash
mkdir 디렉토리명  # 디렉토리 만들기
mkdir -p 경로/하위경로  # 중간 디렉토리 생성
touch  파일명  # 빈파일생성
```

2) 파일 확인 및 경로이동
```bash
ls -al   # 목록보기
pwd      # 현재 경로
cd  디렉토리명 # 디렉토리로 이동
cd ..   # 상위경로
```

```bash
root@acfec9bff0f5:/# pwd
root@acfec9bff0f5:/# ls
root@acfec9bff0f5:/# ls -al
root@acfec9bff0f5:/# cd ~
root@acfec9bff0f5:~# pwd
/root
root@acfec9bff0f5:~#

root@acfec9bff0f5:~# mkdir basic1
root@acfec9bff0f5:~# ls -al
drwxr-xr-x 2 root root 4096 Sep  1 02:18 basic1
root@acfec9bff0f5:~# mkdir -p basic2/a/b/c
root@acfec9bff0f5:~# ls -al
root@acfec9bff0f5:~# cd basic2
root@acfec9bff0f5:~/basic2# cd a
root@acfec9bff0f5:~/basic2/a# cd b
root@acfec9bff0f5:~/basic2/a/b# cd c
root@acfec9bff0f5:~/basic2/a/b/c# ls
root@acfec9bff0f5:~/basic2/a/b/c# cd ~
root@acfec9bff0f5:~# ls
```

Q1. test 폴더만들기
Q2. 폴더안에  test1.txt 파일만들기
Q3. 파일확인 - 디렉토리인지, 폴더인지까지 구분

```bash
root@acfec9bff0f5:~# mkdir test
root@acfec9bff0f5:~# ls
basic1  test
root@acfec9bff0f5:~# cd test
root@acfec9bff0f5:~/test# touch test1.txt
root@acfec9bff0f5:~/test# ls -al
total 8
drwxr-xr-x 2 root root 4096 Sep  1 02:47 .
drwx------ 1 root root 4096 Sep  1 02:47 ..
-rw-r--r-- 1 root root    0 Sep  1 02:47 test1.txt
```

3) 파일 쓰기 > (덮어쓰기) , >> (이어쓰기)
```
root@acfec9bff0f5:~/basic1# cat file1.txt
first
root@acfec9bff0f5:~/basic1# echo "hi" > file1.txt
root@acfec9bff0f5:~/basic1# cat file1.txt
hi
root@acfec9bff0f5:~/basic1# echo "abc" >> file1.txt
root@acfec9bff0f5:~/basic1# cat file1.txt
hi
abc
root@acfec9bff0f5:~/basic1#
```

Q1. test폴더로 이동
Q2. test1.txt 파일에 apple 글쓰기
Q3. test1.txt 파일에 banana, coconut 이어서 쓰기
```bash
root@acfec9bff0f5:~# cd test
root@acfec9bff0f5:~/test# echo "apple" > test1.txt
root@acfec9bff0f5:~/test# cat test1.txt
apple
root@acfec9bff0f5:~/test# echo "banana" >> test1.txt
root@acfec9bff0f5:~/test# echo "coconut" >> test1.txt
root@acfec9bff0f5:~/test# cat test1.txt
apple
banana
coconut
```

4) 삭제 및 복사
```bash
#mv [경로/원본파일]  [이동할 폴더/새파일명]

mv test/test1.txt  basic1/fruits.txt
```
Q1. basic1 폴더의  fruits.txt 파일 을 복사해서 
Q2. test   폴더의  eat.txt 파일명으로 옮기기
```bash
root@acfec9bff0f5:~# mv basic1/fruits.txt test/eat.txt
root@acfec9bff0f5:~# cd ~
root@acfec9bff0f5:~# cd test
root@acfec9bff0f5:~/test# ls
eat.txt
```

5) vi 에디터
```
1. sudo vi file1.txt 실행   ($ 일반사용자 - sudo)
2. vi 안에서 Esc 눌러 명령 모드로 전환   
3. [i] 눌러 입력 모드로 전환 → 새 설정 붙여넣기  , 편집
4. [Esc] → :wq! → 저장 후 종료   
```
> vi문제
Q1.  test 폴더안에  num.txt 파일만들기
Q2.  num.txt vi에디터이용해서
one-1
two-2
three-3 
Q3. 파일확인
```bash
root@acfec9bff0f5:~# cd test/
root@acfec9bff0f5:~/test# touch num.txt
root@acfec9bff0f5:~/test# vi num.txt
root@acfec9bff0f5:~/test# cat num.txt
one-1
two-2
three-3
```

> 정리문제
Q1. 파일만들기   mylinux.txt    vi mylinux.txt
Q2. 파일안에 답채우기  예)
echo
man
touch
mkdir 
ls
cd ..
rm / rm -r (folder)
cp file1.txt back.txt
mv back.txt test.txt

Q3. vi이용해서 맨위에 작성자본인이름 추가 
Q4. mylinux.txt 백업해서 ubuntu에 backup.txt로 
```
root@acfec9bff0f5:~# mkdir ubuntu
root@acfec9bff0f5:~# mv test/mylinux.txt ubuntu/backup.txt
```

Q5. 상위로 이동 testdir 삭제
```
root@acfec9bff0f5:~# mkdir testdir
root@acfec9bff0f5:~# rm -r testdir
```


Q2) 번 문제
-    출력
-    사용서
-    파일생성
-    디렉토리만들기
-    목록보기
-    상위이동
-    파일,폴더삭제
-    file1.txt 을 back.txt으로 파일복사
-    back.txt를 test.txt로 이름변경


#### 5. 유저
1. 유저 추가 및 삭제
```
sudo adduser one
sudo passwd  1111
sudo deluser one
```

```
root@acfec9bff0f5:~# useradd -m one
root@acfec9bff0f5:~# passwd one
New password:
Retype new password:
passwd: password updated successfully

cd /home
su - one
exit
```

root@acfec9bff0f5:/home# su - one
$ mkdir folder1
$ ls -al
total 24
drwxr-x--- 3 one  one  4096 Sep  1 05:45 .
drwxr-xr-x 1 root root 4096 Sep  1 05:42 ..
-rw-r--r-- 1 one  one   220 Mar 31  2024 .bash_logout
-rw-r--r-- 1 one  one  3771 Mar 31  2024 .bashrc
-rw-r--r-- 1 one  one   807 Mar 31  2024 .profile
drwxrwxr-x 2 one  one  4096 Sep  1 05:45 folder1 #775


2. 권한구조 변경
```
ls -al

   d           rwx                           r-x                          --- 2 sally sally 4096 Feb  3 15:04 .    
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1)      그룹(읽기:4/쓰기:-/실행:1)     다른사람(읽기:-/쓰기:-/실행:-)
    d          rwx                           r-x                          r-x 1 root  root  4096 Feb  3 14:59 ..
→  d 디렉토리  소유자(읽기:4/쓰기:2/실행:1)      그룹(읽기:4/쓰기:-/실행:1)     다른사람(읽기:-/쓰기:-/실행:-)
```

■정리 
1. 유저만들기    adduser
2. 권한주기      chmod  750  /home/one   (rwxr-x---) 소유자 그룹 다른사람

#### 6. job + 쉘스크립트
1. 프로세스 상태확인

2. 실시간 모니터링

3. ip주소확인

4. hello world 출력 쉘스크립트 작성
```bash
vi hello.sh

#!/bin/bash
echo "Hello World"
```

```bash
ls -al
```

```bash
chmod +x  hello.sh 

chmod -x  hello.sh  # 권한 빼기
```

```bash
./hello.sh
```

## Part002. Aws

