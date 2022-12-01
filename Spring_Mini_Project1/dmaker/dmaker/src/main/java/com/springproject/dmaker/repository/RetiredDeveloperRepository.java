package com.springproject.dmaker.repository;

// Developer객체를 관리하는 repository interface (db에 저장)

import com.springproject.dmaker.entity.Developer;
import com.springproject.dmaker.entity.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository
        extends JpaRepository<RetiredDeveloper, Long> {

}
