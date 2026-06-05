■1.  git branch
(테스트용 깃주소)
🛠️ 팀장 작업 -깃허브파기 / 팀원초대
> https://github.com/sally03915/2026-ai_branch.git

🛠️ 팀원 작업 흐름
1. 저장소 클론하기
git clone <팀장이 만든 저장소 주소>
cd <저장소 폴더>
```
git clone https://github.com/sally03915/2026-ai_branch.git
cd 2026-ai_branch
```

2. 브랜치 생성하기
git checkout -b feature-브랜치이름
```
git branch                   -- 브랜치 확인
git checkout -b feature-sjy
git branch      브랜치이름     -- 브랜치 변경
```

3. 작업 후 커밋하기
git add .
git commit -m "작업 내용 설명"

4. 원격 저장소에 브랜치 푸시하기
git push origin feature-브랜치이름



🛠️ 팀장과 팀원 작업 흐름