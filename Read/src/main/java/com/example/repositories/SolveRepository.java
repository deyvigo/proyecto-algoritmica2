package com.example.repositories;

import com.example.entities.SolveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SolveRepository extends JpaRepository<SolveEntity, Long> {
    @Query("SELECT COUNT(s) FROM SolveEntity s WHERE s.alumnSolve.id = :alumnId")
    int countSolvesByAlumnId(@Param("alumnId") Long alumnId);
}
