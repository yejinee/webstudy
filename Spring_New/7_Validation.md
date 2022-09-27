# Validation
## 1. Validation?
- 사용자 또는 서버의 요청(http request) 에서 잘못된 내용이 있는지 확인
<br>
</br>

## 2. Validation의 종류
### ✔ 데이터 검증
- 필수 데이터의 존재 유무
- 문자열의 길이나 숫자형 데이터의 경우 값의 범위
- email, 신용카드 번호 등 특정 형식에 맞춘 데이터

### ✔ 비즈니스 검증
- 서비스에 정책에 따라 데이터를 확인하여 검증
- 예) 배달앱인 경우 배달 요청을 할 때 해당 주문건이 결제 완료 상태인지 확인 등
- 경우에 따라 외부 API를 호출하거나 DB의 데이터까지 조회하여 검증하는 경우도 존재

<br>
</br>

## 3. Spring의 Validation
- 웹 레이어에 종속적이지 않은 방법으로 밸리데이션 (데이터 검증에 가까움)

### ✔ Java Bean Validation
- JavaBean 기반으로 간편하게 개별 데이터를 검증
- 요즘에 가장 많이 활용되는 방법
- JavaBean 내에 어노테이션으로 검증방법을 명시함
```
public class MemberCreationRequest {
		@NotBlank(message="이름을 입력해주세요.")
		@Size(max=64, message="이름의 최대 길이는 64자 입니다.")
    private String name;
		@Min(0, "나이는 0보다 커야 합니다.")
    private int age;
		@Email("이메일 형식이 잘못되었습니다.")
    private int email;

    // the usual getters and setters...
}
```
- 위처럼 요청 dto에 어노테이션으로 명시 후 아래처럼 @Valid 어노테이션을 해당 @RequestBody에 달아야함
- Java Bean Validation을 수행한 후 문제가 없을 때만 메서드 내부로 진입
    - 검증 중 실패 시, MethodArgumentNotValidException이 발생

```
@PostMapping(value = "/member")
public MemeberCreationResponse createMember(
	@Valid @RequestBody final MemeberCreationRequest memeberCreationRequest) {
	// member creation logics here...
}
```
<br>
</br>

## 4. Spring validator 인터페이스 구현을 통한 validation
- 현재 잘 사용하지 않는 방법
```
public class Person {

    private String name;
    private int age;

    // the usual getters and setters...
}
```
#### Person이라는 javaBean 객체가 있을 때, 아래는 해당 인스턴스에서만 활용되는 validator
- Person클래스에서만 동작하는 Validator만듬
- 인터페이스에 있는 두개의 메서드의 역할
    - supports : 이 validator가 동작할 조건을 정의, 주로 class의 타입을 비교
    - validate : 원하는 검증을 진행

```
public class PersonValidator implements Validator {

    /**
     * This Validator validates only Person instances
     */
    public boolean supports(Class clazz) {
        return Person.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        ValidationUtils.rejectIfEmpty(e, "name", "name.empty");
        Person p = (Person) obj;
        if (p.getAge() < 0) {
            e.rejectValue("age", "negativevalue");
        } else if (p.getAge() > 110) {
            e.rejectValue("age", "too.darn.old");
        }
    }
}
```

