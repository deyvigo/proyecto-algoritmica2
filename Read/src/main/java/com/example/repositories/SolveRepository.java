package com.example.repositories;

import com.example.entities.SolveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolveRepository extends JpaRepository<SolveEntity, Long> {
}
