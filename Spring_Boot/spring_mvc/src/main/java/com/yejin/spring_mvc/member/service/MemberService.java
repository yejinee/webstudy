package com.yejin.spring_mvc.member.service;

import com.yejin.spring_mvc.member.entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    // PostMember()
    public Member createMember(Member member) {
        // DB저장 후, 내용 변경
        Member createdMember = member;
        return createdMember;
    }
    // patchMember()
    public Member updateMember(Member member) {
        // DB저장 후, 내용 변경
        Member updatedMember = member;
        return updatedMember;
    }
    // getMember()
    public Member findMember(long memberId) {
        // DB 조회
        //Member member = new Member(memberId, "aa@gmail.com", "yejin", "010-1111-2222");
        //return member;
        // Ex. DB에 조회할 수 없기 때문에 예외처리 진행
        throw new RuntimeException("Not found member");
    }
    // getMembers()
    public List<Member> findMembers() {
        // db 조회
        List<Member> members = List.of(
                new Member(1, "aa@gmail.com", "yejin", "010-1111-2222"),
                new Member(2, "bb@gmail.com", "yein", "010-1111-3333")
        );
        return members;
    }
    // deleteMember()
    public void deleteMember(long memberId) {

    }
}
