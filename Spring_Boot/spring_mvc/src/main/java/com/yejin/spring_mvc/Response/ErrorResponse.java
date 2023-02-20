package com.yejin.spring_mvc.Response;

import lombok.Getter;
import org.springframework.validation.BindingResult;
import com.yejin.spring_mvc.exception.BusinessLogicException;
import com.yejin.spring_mvc.exception.ExceptionCode;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
    /*
    DTO 클래스 유효성 검증 실패 시, 실패 필드에 대한 Error정보만 담아서 응답하기 위한 클래스
    * */
    private int status; // 상태코드
    private String message; // 메세지
    private List<FieldError> fieldErrors;   // (1) MethodArgumentNotValidException 으로부터 발생하는 에러 정보를 담는 멤버 변수
    private List<ConstraintViolationError> violationErrors; // (2) ConstraintViolationException 으로부터 발생하는 에러 정보를 담는 멤버 변수

    // (3) 생성자 (private 지정해서 of()메서드 사용해서 객체 생성 가능)
    // => ErrorResponse의 역할을 명확히 하기 위해
    private ErrorResponse(List<FieldError> fieldErrors, List<ConstraintViolationError> violationErrors) {
        this.fieldErrors = fieldErrors;
        this.violationErrors = violationErrors;
    }

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    // (4) MethodArgumentNotValidException에 대한 ErrorResponse 객체 생성
    public static ErrorResponse of(BindingResult bindingResult) {
        return new ErrorResponse(FieldError.of(bindingResult), null);
    }

    // (5) ConstraintViolationException 에 대한 ErrorResponse 객체를 생성
    public static ErrorResponse of(Set<ConstraintViolation<?>> violations) {
        return new ErrorResponse(null, ConstraintViolationError.of(violations));
    }

    // 기능1. 상태코드/에러메세지 출력
    // ExceptionCode에 있는 Member Not Found 출력
    public static ErrorResponse of(BusinessLogicException e) {
        return new ErrorResponse(ExceptionCode.MEMBER_NOT_FOUND.getStatus(), ExceptionCode.MEMBER_NOT_FOUND.getMessage());
    }

    // 기능2. HttpRequestMethodNotSupportedException 처리
    // public static ErrorResponse of(HttpStatus httpStatus){
    //     return new ErrorResponse(httpStatus.value(), httpStatus.getReasonPhrase());
    // }

    // 기능2-1.
    public static ErrorResponse of(HttpRequestMethodNotSupportedException e){
        return new ErrorResponse(ExceptionCode.METHOD_NOT_FOUND.getStatus(), ExceptionCode.METHOD_NOT_FOUND.getMessage());

    }

    // 기능3. handleException 처리
    public static ErrorResponse of(Exception e){
        return new ErrorResponse(ExceptionCode.INTERNAL_SERVER_ERROR.getStatus(), ExceptionCode.INTERNAL_SERVER_ERROR.getMessage());
    }


    // (6) DTO 클래스의 멤버 변수의 유효성 검증에서 발생하는 에러 정보를 생성
    @Getter
    public static class FieldError {
        private String field;
        private Object rejectedValue;
        private String reason;

        private FieldError(String field, Object rejectedValue, String reason) {
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<FieldError> of(BindingResult bindingResult) {
            final List<org.springframework.validation.FieldError> fieldErrors =
                    bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ?
                                    "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }
    }

    // (7) ConstraintViolation Error 가공 (URI 변수 값에 대한 에러 정보를 생성)
    @Getter
    public static class ConstraintViolationError {
        private String propertyPath;
        private Object rejectedValue;
        private String reason;

        private ConstraintViolationError(String propertyPath, Object rejectedValue,
                                         String reason) {
            this.propertyPath = propertyPath;
            this.rejectedValue = rejectedValue;
            this.reason = reason;
        }

        public static List<ConstraintViolationError> of(
                Set<ConstraintViolation<?>> constraintViolations) {
            return constraintViolations.stream()
                    .map(constraintViolation -> new ConstraintViolationError(
                            constraintViolation.getPropertyPath().toString(),
                            constraintViolation.getInvalidValue().toString(),
                            constraintViolation.getMessage()
                    )).collect(Collectors.toList());
        }
    }
}
