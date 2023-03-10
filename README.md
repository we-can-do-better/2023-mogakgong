# ✏️ 모각공

[스터디 소개](https://jaesa5221.notion.site/3f2283ac086546f396ddb9e84c56e47e)

<br/>

## 스터디 방식

1. **9시 30분까지** 구글 미트(google meet)에 참석해야 합니다.
2. **9시 40분까지** 오늘의 학습 목표를 깃헙에 작성합니다.
3. **11시 40분까지** 각자의 학습 목표에 따라 학습합니다.
4. **11시 40분이 되면** 모든 인원이 돌아가며 무엇을 배웠는지 발표하고, 질문을 나눕니다.

<br/>

## 스터디 규칙

### 구글 미트

1. 평일 오전 9시 30분까지 구글 미트에 접속해 있어야 합니다.
2. 접속과 동시에 카메라, 마이크는 `OFF`로 설정합니다.
3. 11시 40분까지 본인의 학습 목표에 따라 진행합니다.
4. 11시 40분이 되면 순서에 따라 모든 인원이 돌아가며 **무엇을** 배웠는지 발표 및 QnA 진행합니다.

**구글 폼을 작성한 이메일로 구글 미트 링크를 공유드렸습니다**

<br/>

### 깃헙

1. 오전 9시 40분까지 학습 목표를 정하고, Github에 Pull Request를 등록합니다.
2. 스터디 종료 시점부터 자정전까지 본인의 PR을 Merge pull request로 반영(merge)합니다.

<br/>


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
