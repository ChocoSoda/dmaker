package com.practice.programming.dmaker.service;

import com.practice.programming.dmaker.Type.DeveloperLevel;
import com.practice.programming.dmaker.Type.DeveloperSkillType;
import com.practice.programming.dmaker.dto.CreateDeveloper;
import com.practice.programming.dmaker.entity.Developer;
import com.practice.programming.dmaker.repository.DeveloperRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;
    private final EntityManager em; // 일종의 DB이다. DB를 추상화한 개념이다.
    @Transactional
    public void createDeveloper(CreateDeveloper.Request request){
            Developer developer = Developer.builder()
                    .developerLevel(DeveloperLevel.JUNIOR)
                    .developerSkillType(DeveloperSkillType.FRONT_END)
                    .experienceYears(2)
                    .name("Olaf")
                    .age(5)
                    .build();

            developerRepository.save(developer);
    }
}
