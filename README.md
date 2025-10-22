# java-racingcar-precourse

---

## 자동차 경주 (Racing Car)

초간단 자동차 경주 게임을 구현

---

## ✅구현 체크리스트

### View

- [ ]  자동차 이름들을 입력받아 넘기기
- [ ]  시도할 횟수 입력받아 넘기기
- [ ]  횟수만큼 자동차 전진 상태 출력
- [ ]  우승자 명단 출력하기

### Controller (흐름)

- [ ]  자동차 이름들 입력받기
- [ ]  입력받은 문자열 나누기
- [ ]  문자열 유효성 검사
- [ ]  시도 횟수 입력 받기
- [ ]  시도 횟수 유효성 검사
- [ ]  자동차 모델 생성
- 아래 반복
    - [ ]  자동차 조건별 전진
    - [ ]  전진 상태 출력
- [ ]  우승자 식별
- [ ]  우승자 명단 출력

### Service

- CarNameSplitterService
    - [ ]  자동차 문자열을 구분자로 나눈다
- ValidatorService
    - 자동차 이름 예외
    - [ ]  자동차 이름이 비어있을 때 NULL 부여
    - [ ]  자동차 이름 길이가 5보다 클 때
    - [ ]  중복된 이름이 있을 때
    - 시도 횟수 입력 예외
    - [ ]  입력 횟수가 숫자가 아닐 때
    - [ ]  입력 횟수가 0일 때
- CarMovementService
    - [ ]  자동차 조건별 전진
- WinnerSelectionService
    - [ ]  우승자 식별 후 반환
- CarCreationService
    - [ ]  자동차 모델들 생성

### Model

- RacingCarModel
- [ ]  모델 구현(이름,전진 횟수, 전진 메서드 등)