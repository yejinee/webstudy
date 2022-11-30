package com.springproject.dmaker.repository;

// Developer객체를 관리하는 repository interface (db에 저장)

import com.springproject.dmaker.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {



}
