package com.practice.programming.dmaker.repository;

import com.practice.programming.dmaker.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Repository 타입의 빈으로 등록될 수 있게 하는 Annotation
public interface RetiredDeveloperRepository
        extends JpaRepository<RetiredDeveloper, Long> {
}
// SpringDateJpa 기능을 통해 간단하게 만들어봤다.