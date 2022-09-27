# Data Binding
## 1. Data Binding?
- 사용자나 외부 서버의 요청 데이터를 특정 도메인 객체에 저장해서 우리 프로그램에 Request에 담아주는 것

## 2. Converter<S, T> Interface
- S(Source)라는 타입을 받아서 T(Target)이라는 타입으로 변환해주는 Interface
### ✔ 인터페이스의 모양
```
package org.springframework.core.convert.converter;

public interface Converter<S, T> {

    T convert(S source);
}
```
### ✔ 요청 처리 예시 1
- 파라미터에 json 형식 문자열이 담겨오는 경우 해당 문자열을 특정 dto에 담기
```
// 요청
GET /user-info
x-auth-user : {"id":123, "name":"Paul"}

// 유저 객체
public class XAuthUser {
    private int id;
    private String name;

    // the usual getters and setters...
}

@GetMapping("/user-info")
public UserInfoResponse getUserInfo(
	@RequestHeader("x-auth-user") XAuthUser xAuthUser){

	// get User Info logic here...
}
```
### ✔ 요청 처리 예시 2
- 헤더에 담긴 json 형식 문자열을 XAuthUser에 바로 담고 싶은 경우, Converter를 Bean으로 등록
```
@Component
public class XAuthUserConverter implements Converter<String, XAuthUser> {
	@Override
	public XAuthUser convert(String source) {
		return objectMapper.readValue(source, XAuthUser.class);
	}
}
```
### ✔ 요청방법 정리
- PathParameter나 기타 특수한 경우의 데이터를 특정 객체에 담고 싶은 경우 
    - i) Converter를 만들어서 Spring에 Bean으로 등록
    - ii) 스프링 내에 ConversionService라는 내장된 서비스에서 Converter 구현체 Bean들을 Converter 리스트에 등록
    - iii) 외부데이터가 들어오고, Source Class Type → Target Class Type이 Converter에 등록된 형식과 일치하면 해당 Converter가 동작


## 3. Formatter
- 특정 객체 ↔ String간의 변환을 담당
- Formatter도 Spring Bean으로 등록하면 자동으로 ConversionService에 등록
    - 필요(요청/응답 시 해당 데이터 타입이 있는 경우)에 따라 자동으로 동작 
- Ex) Date ↔ String 간의 변환을 수행하는 Formatter
    - print : API 요청에 대한 응답을 줄 때, Date형식으로 된 데이터를 특정 locale에 맞춘 String으로 변환
    - parse : API 요청을 받아올 때, String으로 된 "2021-01-01 13:15:00" 같은 날짜 형식의 데이터를 Date로 변환
```
package org.springframework.format.datetime;

public final class DateFormatter implements Formatter<Date> {
    public String print(Date date, Locale locale) {
        return getDateFormat(locale).format(date);
    }

    public Date parse(String formatted, Locale locale) throws ParseException {
        return getDateFormat(locale).parse(formatted);
    }
		// getDateFormat 등 일부 구현은 핵심에 집중하기 위해 생략... 
}
```

