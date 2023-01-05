# IntelliJ / Gradle 첫 시작시 오류
## 1. 'java.exe'' finished with non-zero
```
Process 'command 'java.exe'' finished with non-zero exit value 1
```
## ✔ 해결방안
### (1). [File - Settings]
### (2). [Build, Execution, Deployment - Build Tools - Gradle]
### (3). "Build and run using"을 IntelliJ IDEA로 변경
### (4). "Run tests using"을 IntelliJ IDEA로 변경
### (5). "Gradle JVM"을 버전 변경

<br>

</br>

## 2. re-import the Gradle project and try again.
```
Related gradle configuration was not found. "Please, re-import the Gradle project and try again.
```
## ✔ 해결방안
- Gradle Task관련 View에서 새로고침 버튼
- View 위치
    - [ View - Tool Windows - Gradle ]  


## 3. java: error: release version 19 not supported
```
java: error: release version 19 not supported
```

## ✔ 해결방안
- Settings -> Compiler -> Java Compiler
- Project Bytecode version 확인