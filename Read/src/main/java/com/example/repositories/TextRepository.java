package com.example.repositories;

import com.example.entities.TextEntity;
import java.math.BigInteger;
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
    
    @Query("SELECT t FROM TextEntity t WHERE t.id = :id")
    TextEntity findById(@Param("id") BigInteger id);
}
