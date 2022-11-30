# Settings
## 1. IntelliJ설치
- 해당url에서 Community 다운  
https://www.jetbrains.com/ko-kr/idea/download/#section=windows

<br>
</br>


## 2. To do List API Server 구현
### ✔ 환경설정 및 프로젝트 세팅 
- Gradle 선택

### ✔ 파일설명
- build.gradle : build에 필요한 옵션 정리.
    - 의존성삭제 시 dependencies에 있는값들 삭제해줄 것

### ✔ plug-in추가
- spring boot plugin 추가
```
plugins {
    id 'org.springframework.boot' version '2.4.2'
    id 'io.spring.dependency-management' version '1.0.11.RELEASE'
    id 'java'
}
```


### ✔ dependency 추가
- rest api위한 lib
- jpa관련 기능 사용위함
- in-memory관계형 db를사용
- External Libraries에서도 설치 lib볼 수 있음
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    runtimeOnly 'com.h2database:h2:'
}
```

### ✔ Lombok dependency 추가
- 자바 클래스에서 자주 사용하는 getter, setter 등을 어노테이션을 사용하여 반복되는 작업을 생략하도록 빌드 시점에 자동으로 생성해주는 플러그인
- Intelli J에서 설정 추가해야함
```
annotationProcessor("org.projectlombok:lombok")
compileOnly("org.projectlombok:lombok:")
```

#### Lombok 플러그인 설치
- Preference (Ctrl+Alt+S) → Lombok 설치

<br>
</br>

## 3. 모델구현
- Model / Repository / Service / Controller 4개의  Layer로 나눠서 구현
    - 각 Layer가 제 역할만 하기 위함
    - 코드가 복잡하게 꼬이는거 방지 (코드 관리 용이)

<br>
</br>

## 4. Live Template지정
- Settings ☞ Live Template ☞ Java에서 추가