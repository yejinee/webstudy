# AOP (Aspect Oriented Programming)

## 1. AOP?
- 관점 지향 프로그래밍
- 공통적인 부분을 spring이 받아서 처리해줌
    - 로깅
    - 트랜잭션
    - 인증
- OOP로 처리하기에는 까다로운 부분을 AOP라는 처리 방식을 도입하여 손쉽게 공통 기능을 추가/수정/삭제 할 수 있도록 함

<br>
</br>

## 2. AOP 기본 개념
### ✔ Aspect
- 여러 클래스나 기능에 걸쳐서 있는 관심사, 그리고 그것들을 모듈화함
- AOP 중에서 가장 많이 활용되는 부분은 @Transactional (트랜잭션 관리) 기능
- 특정주제일 때, 무언가를 해야하는 트랜잭션

### ✔ Advice
- 조언, AOP에서 실제로 적용하는 기능(로깅, 트랜잭션, 인증 등)을 뜻함

### ✔ Join point
- 모듈화된 특정 기능이 실행될 수 있는 연결 포인트
- 특정 포인트에 aspect 심어줄 수 있음. 그 지점 의미

### ✔ Pointcut
- Join point 중에서 해당 Aspect를 적용할 대상의 point의미

### ✔ Target Object
- Advice가 적용될 대상 오브젝트(program)

### ✔ AOP Proxy
- 대상 오브젝트에 Aspect를 적용하는 경우 Advice를 덧붙이기 위해 하는 작업을 AOP Proxy라고 함
- 주로 CGLIB(Code Generation Library, 실행 중에 실시간으로 코드를 생성하는 라이브러리) 프록시를 사용하여 프록싱 처리

### ✔ Weaving
- Advice를 비즈니스 로직 코드에 삽입하는 것을 말함

![AOP_Structure](/Spring_New/Image/AOP_Structure.png)


<br>
</br>

## 3. AspectJ
- AspectJ는 AOP를 제대로 사용하기 위해 꼭 필요한 라이브러리
- 기본적으로 제공되는 Spring AOP로는 다양한 기법(Pointcut 등)의 AOP를 사용 X
- Spring에 있으므로 별도 추가 X

### ✔ Aspect 생성
```
package org.xyz;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component  // 해당 Aspect를 스프링의 Bean으로 등록
public class UsefulAspect {
}
```

### ✔ Pointcut 선언
- 해당 Aspect의 Advice(실행할 액션)이 적용될 Join point를 찾기 위한 패턴 또는 조건 생성
- 포인트 컷 표현식이라고 부름
```
package org.xyz;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component  // 해당 Aspect를 스프링의 Bean으로 등록
public class UsefulAspect {

	@Pointcut("execution(* transfer(..))") // pointcut표현식을 통해 pointcut위치 지정
	private void anyOldTransfer() {}
}
```

### ✔ Pointcut 결합
```
package org.xyz;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Component   // 해당 Aspect를 스프링의 Bean으로 등록
public class UsefulAspect {

	@Pointcut("execution(public * *(..))")
	private void anyPublicOperation() {} //public 메서드 대상 포인트 컷

	@Pointcut("within(com.xyz.myapp.trading..*)")
	private void inTrading() {} // 특정 패키지 대상 포인트 컷
	
	@Pointcut("anyPublicOperation() && inTrading()")
	private void tradingOperation() {} // 위의 두 조건을 and(&&) 조건으로 결합한 포인트 컷
}
```

<br>
</br>

## 4. Advice 정의
- Pointcut 활용해 전/후/주변에서 실행될 액션 정의

### ✔ Before Advice
- dataAccessOperation()이라는 미리 정의된 포인트 컷 진입 전에 doAccessCheck가 실행
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class BeforeExample {

    @Before("com.xyz.myapp.CommonPointcuts.dataAccessOperation()")
    public void doAccessCheck() {
        // ...
    }
}
```

### ✔ After Returning Advice
- dataAccessOperation()라는 미리 정의된 포인트컷에서 return이 발생된 후 실행
- 로깅이나 알람띄워줄 때 사용
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.AfterReturning;

@Aspect
public class AfterReturningExample {

    @AfterReturning("com.xyz.myapp.CommonPointcuts.dataAccessOperation()")
    public void doAccessCheck() {
        // ...
    }
}
```
..
### ✔ Around Advice
- businessService()라는 포인트컷의 전/후에 필요한 동작을 추가함
- stopwatch와 같은 기능/lock관리
```
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
public class AroundExample {

    @Around("com.xyz.myapp.CommonPointcuts.businessService()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }
}
```