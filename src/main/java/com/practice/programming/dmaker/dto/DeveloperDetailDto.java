package com.practice.programming.dmaker.dto;

import com.practice.programming.dmaker.Type.DeveloperLevel;
import com.practice.programming.dmaker.Type.DeveloperSkillType;
import com.practice.programming.dmaker.entity.Developer;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeveloperDetailDto {
    private DeveloperLevel developerLevel; //developer 레벨 만들기
    private DeveloperSkillType developerSkillType; //developer Skill Type 만들기

    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    public static DeveloperDetailDto fromEntity(Developer developer){
        return DeveloperDetailDto.builder()
                .developerLevel(developer.getDeveloperLevel())
                .developerSkillType(developer.getDeveloperSkillType())
                .experienceYears(developer.getExperienceYears())
                .age(developer.getAge())
                .name(developer.getName())
                .memberId(developer.getMemberId())
                .build();
    }
}
