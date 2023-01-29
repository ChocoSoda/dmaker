package com.practice.programming.dmaker.entity;

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
public class RetiredDeveloper {
    // 이름이나 나이를 지우고 상태값을 삭제 상태로 바꾸고
    // retiredDeveloper에 분리 보관하는 방식을 채용
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    private String memberId;
    private String name;

    @CreatedDate
    private LocalDateTime creatdeAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    // SpringDate JPA, 내부에 있는 기능들 중에서 자동으로 값을 세팅해주는 기능(Auditing)
    // 자동으로 생성 시점과 최종 수정 시점을 기록해주는 annotation이다.
}
