package com.practice.programming.dmaker.dto;

import com.practice.programming.dmaker.type.DeveloperLevel;
import com.practice.programming.dmaker.type.DeveloperSkillType;
import jakarta.validation.constraints.*;
import lombok.*;

public class EditDeveloper {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request{
        @NotNull
        private DeveloperLevel developerLevel;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;
    }
}
