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


### 4. Artifacts 추가
- Project Structure > Artifacts > + > Web Application: Archive 
    - Name : Project명:war
    - Directory : ~project/target
- Project Structure > Artifacts > + > Web Application: Exploded 
    - Name : Project명:war exploded
    - Directory : ~project/target/project명

### 5. Artifacts 설정
- Run > Edit Configurations > Tomcat 탭 > Deployment > + > Artifact > Exploded Artifact 추가
