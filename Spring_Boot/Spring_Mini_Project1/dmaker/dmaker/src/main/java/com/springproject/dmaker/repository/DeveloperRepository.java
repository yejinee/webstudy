package com.springproject.dmaker.repository;

// Developer객체를 관리하는 repository interface (db에 저장)

import com.springproject.dmaker.code.StatusCode;
import com.springproject.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {

    // 특정 col명으로 검색
    Optional<Developer> findByMemberId(String memberId);

    List<Developer> findDevelopersByStatusCodeEquals(StatusCode statusCode);
}
