# Spring MVC
## 과정
### 1. Tomcat 설정
- Run -> Edit Configurations -> Tomcat local 등록

### 2. build.gradle 수정
- Tomcat에서 패키징 시, jar가 아닌 war파일 사용
```
plugins {
    id 'java'
    id 'war'
}
```

### 3. Tomcat Deployment 설정
- Run -> Edit Configurations -> Tomcat Server - Deployment - SNAPSHOT추가
