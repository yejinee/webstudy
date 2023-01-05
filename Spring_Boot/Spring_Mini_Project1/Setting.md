# Project 구현
## 1. 기본구조 만들기

<br>
</br>

## 2. H2 DataBase
## ✔ H2 특징
- 단독 설치 안해도 된다
- test전용으로 사용
## 사용방법
### 1. application.properties 파일 수정
    spring:
        h2:
            console:
                enabled: true

### 2. h2에 접속
- http://localhost:8080/h2-console 에 접속

<br>
</br>

## 3. Builder Pattern
- entity/Dto객체에 값을 넣어줄 때 @Builder사용
- 생성자에서 인자가 많을때 고려

<br>
</br>

### ✔ 과거의 생성자 패턴
### 1. 점증적 생성자 패턴
- 생성자에 매개변수 넣어서 만듬
- 단점
    - 인자 많아질수록 생성자 많아짐
    - 매개변수 정보를 설명할 수 없어서 어떤 객체에 어떤 인자가 있는지 알기 어려움
### 2. Java Beans 패턴
- 점증적 생성자 패턴의 단점 보완
- 빈생성자 만들고 set이용해서 객체 선언
- 단점
    - 객체 일관성이 깨짐 (객체 생성시, 객체가 변할 여지가 있음)
### 3. Builder 패턴
- Java Beans처럼 정보를 받지만 데이터 일관성을 위해 정보 다 받고 객체 저장함
<br>
</br>

### ✔ 생성방법
- 클래스 내부에 builder클래스 생성
- 각 멤버변수별 메서드 작성
    - 메소드는 변수, setter  하고 builder객체를 리턴
    ```
    public class PersonInfo{
        private String name;    // 필수변수
        private int age;    // 선택변수
        private PersonInfo() {}
        public static class Builder {
            private String name;
            private int age;
            // 필수변수는 생성자로 값을 넣는다.
            public Builder(String name) { this.name = name; }

             // 멤버변수별 메소드 - 빌더클래스의 필드값을 set하고 빌더객체를 리턴
            public Builder setAge(int age) {
                this.age = age;
                return this;
            }

            // 빌더메소드
            public PersonInfo build() {
            PersonInfo personInfo = new PersonInfo();
            personInfo.name = name;
            personInfo.age = age;
            return personInfo;
            }
        }

    }

    PersonInfo personinfo = new PersonInfo
    .Builder("SeungJin")    // 필수값 입력 ( 빌더클래스 생성자로 빌더객체 생성)
    .setAge(25) // 값 set
    .build()    // build() 가 객체를 생성해 return
    
    ```


## 인터페이스 주입
### @RequiredArgsConstructor 사용
- 과거에는 @Autowired, @Inject이용해서 객체 주입했으나 종속성의 문제 발생하여 사용하지 않음
- 생성자를 생성하는 방식으로 문제를 해결(이를 담은게 RequiredArgsConstructor)


