**[깃헙 사용 메뉴얼]**

1. 해당 저장소를 clone 합니다.
```
$ git clone https://github.com/we-can-do-better/2023-mogakgong.git
```

2. clone 한 디렉터리로 이동 후 본인 이름(github id)의 브랜치로 체크아웃 합니다.
```
$ git checkout -b {github_id}
ex) git checkout -b ahn-sj
```

3. 학습 목표를 마크다운(xx.md)으로 다음과 같은 형식으로 작성합니다.
```
- [ ] 학습목표1
- [ ] 학습목표2
- [ ] 학습목표3
...
```

4. 본인의 폴더에 add/commit/push 합니다.
```
$ git add .
$ git commit -m "[이름] 날짜" // [성재] 03월 04일
$ git push origin {본인 브랜치 명}
```

5. Github에서 Pull Request를 등록합니다.<br/>
   5-1) 저장소 내 `Pull requests` 메뉴로 이동<br/>
   5-2) `New pull request` 버튼 클릭<br/>
   5-3) base 브랜치는 `master`, compare 브랜치를 `{본인 브랜츠 명}`으로 설정<br/>
   5-4) 제목은 커밋 메세지와 동일하게 작성하고 `Create pull request` 를 클릭하여 PR 등록<br/>

6. 스터디 종료 후부터 해당 날짜 자정까지 본인의 PR을 `Merge pull request` 버튼을 눌러 반영(merge)합니다.<br/>
