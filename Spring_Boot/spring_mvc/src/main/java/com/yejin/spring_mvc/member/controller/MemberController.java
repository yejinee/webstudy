package com.yejin.spring_mvc.member.controller;
import com.yejin.spring_mvc.Response.ErrorResponse;
import com.yejin.spring_mvc.member.mapper.MemberMapper;
import com.yejin.spring_mvc.member.service.MemberService;
import com.yejin.spring_mvc.member.dto.MemberPatchDto;
import com.yejin.spring_mvc.member.dto.MemberPostDto;
import com.yejin.spring_mvc.member.dto.MemberResponseDto;
import com.yejin.spring_mvc.member.entity.Member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/members")
@Validated
@Slf4j
public class MemberController {
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    public MemberController(MemberService memberService, MemberMapper memberMapper) {
        this.memberService = memberService;
        this.memberMapper = memberMapper;
    }

    // 회원 정보 등록
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
        // mapper를 이용해 MemberPostDto를 Member로 변환
        Member member = memberMapper.memberPostDtoToMember(memberDto);
        // 서비스 계층과의 연결
        Member response = memberService.createMember(member);
        // mapper를 이용해 Member를 MemberResponseDto로 변환
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response), HttpStatus.CREATED);
    }

    // 회원 정보 수정
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberPatchDto) {
        memberPatchDto.setMemberId(memberId);

        Member response = memberService.updateMember(memberMapper.memberPatchDtoToMember(memberPatchDto));

        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    // 한명의 회원 정보 조회
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        Member response = memberService.findMember(memberId);
        return new ResponseEntity<>(memberMapper.memberToMemberResponseDto(response), HttpStatus.OK);
    }

    // 모든 회원 정보 조회
    @GetMapping
    public ResponseEntity getMembers() {
        List<Member> members = memberService.findMembers();
        // mapper를 이용해 List<Member>를 MemberResponseDto로 변환
        List<MemberResponseDto> response = members.stream()
                .map(member -> memberMapper.memberToMemberResponseDto(member)).collect(Collectors.toList());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {

        memberService.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @ExceptionHandler
    public ResponseEntity handleException(MethodArgumentNotValidException e) {
        /*
        Case ) Validation 실패한 경우
        - MethodArgumentNotValidException 발생
        - 해당 Exception 발생 시, handleException 메서드 실행(예외처리)
         */

        // 1. 모든 에러 정보 확인 가능
        final List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();

        // 2. 필요한 에러 정보들만 선택적으로 걸라서 전달
        List<ErrorResponse.FieldError> errors =
                fieldErrors.stream()
                        .map(error -> new ErrorResponse.FieldError(
                                error.getField(),
                                error.getRejectedValue(),
                                error.getDefaultMessage()))
                        .collect(Collectors.toList());


        // 에러 정보를  Response Body로 전달
        return new ResponseEntity<>(new ErrorResponse(errors), HttpStatus.BAD_REQUEST);
    }
}
