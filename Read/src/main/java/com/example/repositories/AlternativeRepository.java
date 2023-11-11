package com.example.repositories;

import com.example.entities.AlumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlternativeRepository extends JpaRepository<AlumnEntity, Long> {
}
