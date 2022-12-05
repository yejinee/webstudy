# Spring의 핵심 기능 정리
## <span style='background-color:#FFF5b1'> 1. IoC Container <span>
### 예시 #1
```
public class ServerFacade
{
  public Object respondToRequest(Object pRequest)
  {
    if(businessLayer.validateRequest(pRequest))
    {
      DAO.getData(pRequest);
      return Aspect.convertData(pRequest);
    }

    return null;
  }
}
```
- "ServerFacade" 클래스가 validateRequest/Aspect등 모든 정보를 다 알아야한다. (결합되어있다)
- 해당 정보들이 변경된다면 ServerFacade가 영향을 받음

### 예시 #2
```
public class ServerFacade
{
  public Object respondToRequest(Object pRequest, DAO dao)
  {
    return dao.getData(pRequest);
  }
}

```
- DAO도 파라미터로 넣어줌(사용자가 DAO를 다른걸 넣어도 해당작업 수행 가능)

<br>
</br>

## <span style='background-color:#f5f0ff'> ✔ Framework & Library의 차이점 <span>
### Library 
- 코드가 라이브러리를 호출
```
class HelloServiceTest{
  @Test
  void test(){
    Assertions.assertEquals("Hello"); // library직접 호출
  }
}
```

### Framework 
- 프레임워크가 내 코드를 호출
- 엔티티를 정의(new키워드)하지 않았음에도 helloService사용 가능
  - Spring Framework의 "Autowired" 기능 이용해서 HelloService를 주입함
```
class HelloServiceTest{
  @Autowired
  private HelloService helloService;
  @Test
  void test(){
    String result = helloService.hello(input); 
  }
}
```

<br>

</br>

## <span style='background-color:#FFF5b1'> 2. Resources <span>
- low level resource에 접근할 수 있는 기능 제공

<br>

</br>

## <span style='background-color:#FFF5b1'> 3. Validation, Data Binding, Type Conversion <span>
- 데이터 검증
- 데이터 인식 및 자료형 할당/변환

### 예시 #1
- Size, NotNull과 같은 코드를 반복해서 구현하지 않게함
```
public class PersonForm{
  @NotNull
  @Size(min=2, max=30)  // 반복 구현 방지
  private String name;
}
```
### 예시 #2
- path를 읽어온 값(id)가 String/Integer상관없이 알아서 처리해줌
  - 비즈니스적인 로직만 생각할 수 있음
```
@GetMapping("/api/{id}")
@ResponseBody
public String getEmployeeById(@PathVariable String id){
  return "ID: " + id; //알아서 처리 가능
}
```
### 예시 #3
- 입력자료형을 변환해서 출력해주는 기능 제공
```
final class StringToInteger implements Converter<String, Integer>{
  public Integer conver(String source){
    return Integer.valueOf(source);
  }
}
```
<br>

</br>

## <span style='background-color:#FFF5b1'> 4. Spring Expression Language(SpEL) <span>
- Spring App Runtime에 다양한 데이터에 접근하기 위한 언어
### 예시
- 해당위치에 파일 읽어들여서 valueFromFile에 저장
```
@Value("${value.from.file}")  //해당위치의 property에 접근
private String valueFromFile;
```
<br>

</br>

## <span style='background-color:#FFF5b1'> 5. Aspect Oriented Programming (AOP) <span>
- 공통 기능을 개발자의 코드 밖에서 필요한 시점에 적용 가능하게 함
- 비즈니스적인 요소와 공통적인 기능을 분리해서 사용할 수 있도록 함
- EX) Proxy, Aspect, Join Point, Advice, Pointcut, Weaving...
### 예시
- 비즈니스 로직뿐이지만, 트랜잭션을 보장
- @Transactional을 통해 UPDATE/ROLLBACK 등 트랜잭션까지도 지원
```
@Transactional
public boolean update(int score){
  return scoreService.updateScores(score);
}
```

<br>

</br>

## <span style='background-color:#FFF5b1'> 6. Null safety <span>
- null-safe한 코드 작성 지원
- Ex) @Nullable / @NonNull / @NonNullApi / @NonNullFields


<br>

</br>

## <span style='background-color:#FFF5b1'> 7. Logging <span>
- 별도의 외부 설정 없이 로깅 구현체 사용 가능 