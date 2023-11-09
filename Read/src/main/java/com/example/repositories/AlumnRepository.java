package com.example.repositories;

import com.example.entities.AlumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnRepository extends JpaRepository<AlumnEntity, Long> {
    Optional<AlumnEntity> findByUsername(String username);
}
