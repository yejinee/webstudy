# Lombok이란?

### 💡 자바 클래스에서 자주 사용하는 getter, setter 등을 어노테이션을 사용하여 반복되는 작업을 생략하도록 빌드 시점에 자동으로 생성해주는 플러그인


<br>
</br>

## Lombok 기능

### @Getter / @Setter

- Class 이름 위에 적용시키면 모든 변수들에 적용 가능
- 변수 이름 위에 적용시키면 해당 변수들만 적용 가능

### **@AllArgsContructor

- 모든 변수를 사용하는 생성자를 자동완성

### @NoArgsContructor

- 어떤 변수도 사용하지 않는 생성자를 자동완성

### @RequiredArgsConstructor

- 특정 변수만을  활용하는 생성자를 자동완성
- 생성자의 인자로 추가할 변수에 ### @NotNull 어노테이션 붙여서 생성자의 인자로 추가 가능

### @ToString

- class 변수들기반으로 ToString 메소드 자동완성
- 출력 원하지 않는 변수에 ### @ToString.Exclude###  붙이면 출력 제외 가능

### @Data
- ### @ToString , @EqualsAndHashCode , @Getter , @Setter , @RequiredArgsConstructor 자동완성 시켜줌
- 실무에서는 너무 무겁고 객체의 안정성 지키기 위해 지양


### @Column
- 객체 필드와 DB 테이블 컬럼 mapping
- 속성
    - name : 맵핑할 테이블의 컬럼 이름을 지정
    - **nullable :** NULL을 허용할지, 허용하지 않을지 결정

### @Id
- JPA가 객체를 관리할 때 식별할 기본키를 지정


### @GeneratedValue###  
- Primary key 식별키의 전략 설정

### @Entity
- 선언 시 그 클래스는 JPA가 관리
- DB의 테이블과 Class(VO, DTO)와 맵핑한다면 반드시 @Entity를 붙여주어야 함

### @Table
- 맵핑할 테이블을 지정