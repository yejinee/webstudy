package com.springproject.dmaker.service;

import com.springproject.dmaker.dto.CreateDeveloper;
import com.springproject.dmaker.entity.Developer;
import com.springproject.dmaker.repository.DeveloperRepository;
import com.springproject.dmaker.type.DeveloperLevel;
import com.springproject.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
public class DMakerService {
    // RequiredArgsConstructor 사용하면 자동으로 interface 주입
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(CreateDeveloper.Request request){
        validationCreateDeveloperRequest(request);

        // Entity 생성
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevel.JUNIOR)
                .developerSkillType(DeveloperSkillType.FRONT_END)
                .experienceYears(2)
                .name("olaf")
                .age(5)
                .build();
        // 객체를 db에 저장
        developerRepository.save(developer);
    }

    private void validationCreateDeveloperRequest(CreateDeveloper.Request request){
        // business validation
        if (request.getDeveloperLevel() == DeveloperLevel.SENIOR && request.getExperienceYears()<10){
            throw  new RuntimeException("SENIOR needs 10 yrs experience");
        }


    }

}
