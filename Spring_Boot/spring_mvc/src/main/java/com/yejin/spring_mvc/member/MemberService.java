package com.yejin.spring_mvc.member;

import java.util.List;

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
        Member member = new Member(memberId, "aa@gmail.com", "yejin", "010-1111-2222");
        return member;
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
