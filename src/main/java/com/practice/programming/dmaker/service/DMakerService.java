package com.practice.programming.dmaker.service;

import com.practice.programming.dmaker.Type.DeveloperLevel;
import com.practice.programming.dmaker.dto.CreateDeveloper;
import com.practice.programming.dmaker.entity.Developer;
import com.practice.programming.dmaker.exception.DMakerException;
import com.practice.programming.dmaker.repository.DeveloperRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.practice.programming.dmaker.exception.DMakerErrorCode.DUPLICATED_MEMBER_ID;
import static com.practice.programming.dmaker.exception.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em; // 일종의 DB이다. DB를 추상화한 개념이다.
    @Transactional
    public CreateDeveloper.Response createDeveloper(CreateDeveloper.Request request){
        validationCreateDeveloperRequest(request);

            Developer developer = Developer.builder()
                    .developerLevel(request.getDeveloperLevel())
                    .developerSkillType(request.getDeveloperSkillType())
                    .experienceYears(request.getExperienceYears())
                    .name(request.getName())
                    .age(request.getAge())
                    .build();

            developerRepository.save(developer);
            return CreateDeveloper.Response.fromEntity(developer);
    }

    private void validationCreateDeveloperRequest(CreateDeveloper.Request request) {
        // business validation을 수행
        DeveloperLevel developerLevel = request.getDeveloperLevel();
        Integer experienceYears = request.getExperienceYears();
        if (developerLevel == DeveloperLevel.SENIOR && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNGNIOR && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }
        if (developerLevel == DeveloperLevel.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        developerRepository.findByMemberId(request.getMemberId()).ifPresent(
                developer -> {throw new DMakerException(DUPLICATED_MEMBER_ID);
                });
    }
}
