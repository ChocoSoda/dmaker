package com.practice.programming.dmaker.entity;

import com.practice.programming.dmaker.Type.DeveloperLevel;
import com.practice.programming.dmaker.Type.DeveloperSkillType;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
// 위 5개는 Entity에 기본으로 많이 달고 다니는 형식
// Constructor 2개는 빌더를 쓸려면 기본적으로 있어야 오류가 덜 발생한다.
@Entity
@EntityListeners(AuditingEntityListener.class)
// 생성 시기, 최종 수정 시기를 자동으로 기입하기 위해 필요한 Annotation
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    // 위 세 줄은 Developer를 활성화(빨간줄 제거)시키기 위해 입력.
    @Enumerated(EnumType.STRING)
    private DeveloperLevel developerLevel; //developer 레벨 만들기
    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType; //developer Skill Type 만들기

    private Integer experienceYears;
    private String memberId;
    private String name;
    private Integer age;

    @CreatedDate
    private LocalDateTime creatdeAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    // SpringDate JPA, 내부에 있는 기능들 중에서 자동으로 값을 세팅해주는 기능(Auditing)
    // 자동으로 생성 시점과 최종 수정 시점을 기록해주는 annotation이다.
}
