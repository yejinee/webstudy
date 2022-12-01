package com.springproject.dmaker.service;

import com.springproject.dmaker.code.StatusCode;
import com.springproject.dmaker.dto.CreateDeveloper;
import com.springproject.dmaker.dto.DeveloperDetailDto;
import com.springproject.dmaker.dto.DeveloperDto;
import com.springproject.dmaker.dto.EditDeveloper;
import com.springproject.dmaker.entity.Developer;
import com.springproject.dmaker.entity.RetiredDeveloper;
import com.springproject.dmaker.exception.DMakerException;
import com.springproject.dmaker.repository.DeveloperRepository;
import com.springproject.dmaker.repository.RetiredDeveloperRepository;
import com.springproject.dmaker.type.DeveloperLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.springproject.dmaker.exception.DMakerErrorCode.*;

@Service
@RequiredArgsConstructor
public class DMakerService {
    // RequiredArgsConstructor 사용하면 자동으로 interface 주입
    private final DeveloperRepository developerRepository;
    private final RetiredDeveloperRepository retiredDeveloperRepository;

    @Transactional
    // Developer를 create하기 위함
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validationCreateDeveloperRequest(request);

        // Entity 생성
        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .statusCode(StatusCode.EMPLOYED)
                .name(request.getName())
                .age(request.getAge())
                .build();
        // 객체를 db에 저장
        developerRepository.save(developer);
        // response dto를 생성
        return CreateDeveloper.Response.fromEntity(developer);

    }
    // developer정보 create시, 값 validation확인 위함
    private void validationCreateDeveloperRequest(CreateDeveloper.Request request) {
        // business validation
        validateDeveloperLevel(request.getDeveloperLevel(), request.getExperienceYears());

//        developerRepository.findByMemberId(request.getMemberId())
//                .isPresent((developer -> {
//                    throw new DMakerException(DUPLICATED_MEMBER_ID);
//                }));


        // memberid 중복 불가 처리(JAVA 11)
        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
         if (developer.isPresent()) throw new DMakerException(DUPLICATED_MEMBER_ID);
    }

    // 모든 Developer의 정보 GET
    public List<DeveloperDto> getAllEmployedDevelopers() {
        return developerRepository.findDevelopersByStatusCodeEquals(StatusCode.EMPLOYED)
                .stream().map(DeveloperDto::fromEntity)//받아온걸 developedto로 바꿔주는 매핑작업
                .collect(Collectors.toList()); // type변경
    }

    // memberid에 해당하는 developer의 정보 GET
    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId) //memberid활용해 entity가져옴
                .map(DeveloperDetailDto::fromEntity)  //Developer Entity를 DeveloperDetailDto로 변환
                .orElseThrow(() -> new DMakerException(NO_DEVELOPER));   // 값이 있을때 get해서 반환, 없으면 특정 동작 수행

    }

    // memberid와 request body의 값을 불러와서 그 값으로 수정
    @Transactional
    public DeveloperDetailDto editDeveloper(String memberId, EditDeveloper.Request request) {
        validationEditDeveloperRequest(request, memberId);
        Developer developer = developerRepository.findByMemberId(memberId).orElseThrow(
                () -> new DMakerException(NO_DEVELOPER)
        );
        developer.setDeveloperLevel(request.getDeveloperLevel());
        developer.setDeveloperSkillType(request.getDeveloperSkillType());
        developer.setExperienceYears(request.getExperienceYears());

        return DeveloperDetailDto.fromEntity(developer);
    }

    private void validationEditDeveloperRequest(EditDeveloper.Request request, String memberId) {
        validateDeveloperLevel(request.getDeveloperLevel(), request.getExperienceYears());
        developerRepository.findByMemberId(memberId).orElseThrow(
                () -> new DMakerException(NO_DEVELOPER)
        );

    }

    private static void validateDeveloperLevel(DeveloperLevel developerLevel, Integer experienceYears) {
        if (developerLevel == DeveloperLevel.SENIOR && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR
                && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && (experienceYears > 4)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
    }
    @Transactional
    public DeveloperDetailDto deleteDeveloper(String memberId) {
        // Atomic한 특성때문에 데이터 삭제말고 retire했다고 처리해줄것
        // 1. EMPLOYED -> RETIRED
        Developer developer = developerRepository.findByMemberId(memberId).orElseThrow(
                () -> new DMakerException(NO_DEVELOPER)
        );
        developer.setStatusCode(StatusCode.RETIRED);
        // 2. SAVE INTO RETIREDEVELOPER TABLE
        RetiredDeveloper retiredDeveloper = RetiredDeveloper.builder().memberId(memberId)
                .name(developer.getName())
                .build();

        retiredDeveloperRepository.save(retiredDeveloper);
        return DeveloperDetailDto.fromEntity(developer);
    }
}
