package com.example.repositories;

import com.example.entities.TextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TextRepository extends JpaRepository<TextEntity, Long> {

    @Query("SELECT t FROM TextEntity t WHERE t.content LIKE %:keyword%")
    Set<TextEntity> findByKeyword(@Param("keyword") String keyword);

}
