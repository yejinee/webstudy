# Port 문제 해결 방법
## ✔ 오류메세지
```
Web server failed to start. Port 8080 was already in use.
```

## ✔ 해결방법
### (1). CMD 창 켜기
### (2). 활성 연결된 프로세스 목록 확인
```
netstat -ano
```
### (3). Port에 해당하는 Process Kill
```
taskkill /pid Port번호 /f
```
