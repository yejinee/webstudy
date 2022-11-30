# HTTP (Hyper Text Transfer Protocol)

## 1. HTTP?
- Hyper 텍스트를 전송하는데 활용하는 protocol
- 요청과 응답의 정의에 대해서만 간략 설명
<br>
</br>

## 2. HTTP Request 메시지
- 첫째줄: 요청라인(HTTP 메서드(GET, PUT, POST 등)
- 두번째줄부터 줄바꿈 나오기 전까지: Header(User-Agent, Accept 등)
- 헤더에서 줄바꿈 이후: Request Body
- GET의 경우 body를 넣지 x 
- POST의 경우 body를 넣어줌
```
POST /create-developer HTTP/1.1
Content-Type: application/json
Accept: application/json

{
  "developerLevel": "JUNIOR",
  "developerSkillType": "FULL_STACK",
  "experienceYears": 2,
  "memberId": "sunny.flower",
  "name": "sun",
  "age": 36
}
```
<br>
</br>

## 3. HTTP Response 메시지 
- 첫째줄: 상태라인(200, 500, 등)
- 두번째줄부터 줄바꿈 나오기 전까지: Header
- 헤더에서 줄바꿈 이후: Request Body
```
HTTP/1.1 200 OK
Content-Type: application/json
Transfer-Encoding: chunked
Date: Sat, 17 Jul 2021 15:33:34 GMT
Keep-Alive: timeout=60
Connection: keep-alive

{
  "developerLevel": "JUNIOR",
  "developerSkillType": "FULL_STACK",
  "experienceYears": 2,
  "memberId": "sunny.flo1wer",
  "name": "sun",
  "age": 36
}
```


