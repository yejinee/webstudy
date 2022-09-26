# IoC (Inversion of Control) / DI (Dependency Injection)

## 1. Bean?
- 보통은 property/method가 존재하고 method가 property이용해서 class의 행위를 함
### ✔ Java에서의 javaBean
- 데이터를 저장하기 위한 용도로만 사용하는 단순한 구조체
- private property & getter/setter로만 데이터 접근 가능
    - property에 직접적인 접근은 불가능하고 getter/setter이용해서만 접근

### ✔ Spring에서의 Bean
- IoC Contaier에 User가 만든 class를 bean으로 설정하면 등록됌
- 각각의 Bean들 끼리는 서로 의존(사용) 가능

## 2. Spring Container 개요
- ApplcationContext Interface에서 Bean객체 생성 + 설정값 입혀서 관리

### ✔ Bean등록
- 과거는 xml기반으로 설정 관리
- 현재는 annotation 기반으로 Bean등록 (ex. @Bean, @Controller, @Service)

#### Bean 등록 시 정보(Scope)
- Scope : Bean을 생성하는 규칙
    - singleton : 컨테이너에 단일로 생성 (바뀌지x)
    - prototype: 작업 시마다 Bean을 새로 생성하고 싶을 경우 (Spring Batch에서 사용)
    - request: http 요청마다 새롭게 Bean을 생성하고 싶은 경우


### ✔ Bean LifeCycle callback(빈 생명주기 콜백함수)
- callback : 어떤 이벤트가 발생하는 경우 호출되는 메서드
- lifecycle callback
    - Bean을 생성하고 초기화하고 파괴하는 등 특정 시점에 호출되도록 정의된 함수
- 주로 많이 사용되는 콜백
    - @PostConstruct : 빈 등록 시점에 자동으로 함수 수행 (Connection하는 경우 활용)
    - @PreDestroy : 빈 파괴(주로 어플리케이션 종료) 시점에 필요한 작업을 수행