package com.yejin.spring_mvc.member.service;

import com.yejin.spring_mvc.exception.BusinessLogicException;
import com.yejin.spring_mvc.exception.ExceptionCode;
import com.yejin.spring_mvc.member.entity.Member;
import com.yejin.spring_mvc.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    // MemberRepository DI
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        // 이미 등록된 이메일인지 검증
        verifyExistsEmail(member.getEmail());
        return memberRepository.save(member);
    }


    public Member updateMember(Member member) {
        // 존재하는 회원인지 검증
        Member findMember = findVerifiedMember(member.getMemberId());

        // 이름&폰 번호 정보 업데이트 (회원 존재여부 검증에 통과하면 번경)
        // ofNullable => 멤버변수 NULL값 허용
        Optional.ofNullable(member.getName()).ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone()).ifPresent(phone -> findMember.setPhone(phone));

        return memberRepository.save(findMember);

    }

    public Member findMember(long memberId) {
        // 특정 회원 정보 조회
        return findVerifiedMember(memberId);
    }

    public List<Member> findMembers() {

        // 모든 회원 정보 조회
        return (List<Member>) memberRepository.findAll();
    }

    public void deleteMember(long memberId) {
        // 특정 회원 정보 삭제
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    // 이미 존재하는 회원인지 검증
    public Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        // orElseThorow() => optionalMember 객체가 null 이 아니라면 해당 객체를 리턴하고 null이라면 예외를 던짐
        Member findMember = optionalMember.orElseThrow(() -> new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return findMember;
    }

    // 이미 등록된 이메일인지 검증
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent())
            throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);

    }


}
