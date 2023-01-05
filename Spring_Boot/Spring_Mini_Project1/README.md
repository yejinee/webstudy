# Spring Mini Project
## 1. Project 시나리오
- User가 Http로 접속 요청
- App이 요청받은 정보를 사용할 수 있는 객체에 담음
- Validation 검증 완료 시, DB와 Transaction 주고받음
- 예외발생 시, 예외처리
- 처리 완료 후, HTTP응답

![AOP_Structure](/Image/MiniProject_Structure.png)

<br>
</br>

## 2. 주요 기능
### 개발자 생성하기
- POST 메서드를 활용하여 개발자를 생성
- validation 처리

### 개발자 목록과 특정 개발자 상세 내용 확인
- GET 메서드를 활용하여 개발자의 정보 확인
- DTO(Data Transfer Object)의 개념과 역할

### 개발자 정보 수정
- PUT 메서드를 활용하여 개발자의 정보 수정

### 개발자 삭제
- DELETE 메서드를 활용하여 개발자의 정보를 삭제(분리보관)
- 트랜잭션 처리