package com.springproject.dmaker.service;

import com.springproject.dmaker.dto.CreateDeveloper;
import com.springproject.dmaker.dto.DeveloperDetailDto;
import com.springproject.dmaker.dto.DeveloperDto;
import com.springproject.dmaker.entity.Developer;
import com.springproject.dmaker.exception.DMakerErrorCode;
import com.springproject.dmaker.exception.DMakerException;
import com.springproject.dmaker.repository.DeveloperRepository;
import com.springproject.dmaker.type.DeveloperLevel;
import com.springproject.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.springproject.dmaker.exception.DMakerErrorCode.*;

@Service
@RequiredArgsConstructor
public class DMakerService {
    // RequiredArgsConstructor 사용하면 자동으로 interface 주입
    private final DeveloperRepository developerRepository;

    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request) {
        validationCreateDeveloperRequest(request);

        // Entity 생성
        Developer developer = Developer.builder()
                .developerLevel(request.getDeveloperLevel())
                .developerSkillType(request.getDeveloperSkillType())
                .experienceYears(request.getExperienceYears())
                .memberId(request.getMemberId())
                .name(request.getName())
                .age(request.getAge())
                .build();
        // 객체를 db에 저장
        developerRepository.save(developer);
        // response dto를 생성
        return CreateDeveloper.Response.fromEntity(developer);

    }

    private void validationCreateDeveloperRequest(CreateDeveloper.Request request) {
        // business validation

        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();

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

//        developerRepository.findByMemberId(request.getMemberId())
//                .isPresent((developer -> {
//                    throw new DMakerException(DUPLICATED_MEMBER_ID);
//                }));


        // memberid 중복 불가 처리(JAVA 11)
        Optional<Developer> developer = developerRepository.findByMemberId(request.getMemberId());
         if (developer.isPresent()) throw new DMakerException(DUPLICATED_MEMBER_ID);
    }

    public List<DeveloperDto> getAllDevelopers() {
        return developerRepository.findAll()
                .stream().map(DeveloperDto::fromEntity)//받아온걸 developedto로 바꿔주는 매핑작업
                .collect(Collectors.toList()); // type변경
    }

    public DeveloperDetailDto getDeveloperDetail(String memberId) {
        return developerRepository.findByMemberId(memberId) //memberid활용해 entity가져옴
                .map(DeveloperDetailDto::fromEntity)  //Developer Entity를 DeveloperDetailDto로 변환
                .orElseThrow(() -> new DMakerException(NO_DEVELOPER));   // 값이 있을때 get해서 반환, 없으면 특정 동작 수행

    }
}
