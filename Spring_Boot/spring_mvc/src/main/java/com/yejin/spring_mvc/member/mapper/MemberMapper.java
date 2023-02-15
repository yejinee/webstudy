package com.yejin.spring_mvc.member.mapper;
import com.yejin.spring_mvc.member.dto.MemberPatchDto;
import com.yejin.spring_mvc.member.dto.MemberPostDto;
import com.yejin.spring_mvc.member.dto.MemberResponseDto;
import com.yejin.spring_mvc.member.entity.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")  // MapStruct의 매퍼 인터페이스로 정의 (Bean등록)
public interface MemberMapper {
    Member memberPostDtoToMember(MemberPostDto memberPostDto);

    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);

    MemberResponseDto memberToMemberResponseDto(Member member);
}
