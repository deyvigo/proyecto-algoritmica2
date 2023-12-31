package com.example.repositories;

import com.example.entities.SolveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.validation.ObjectError;

import java.util.List;

@Repository
public interface SolveRepository extends JpaRepository<SolveEntity, Long> {
    @Query("SELECT COUNT(s) FROM SolveEntity s WHERE s.alumnSolve.id = :alumnId")
    int countSolvesByAlumnId(@Param("alumnId") Long alumnId);

    @Query("SELECT s FROM SolveEntity s WHERE s.alumnSolve.id = :alumnId")
    List<SolveEntity> findAllSolvesByAlumnId(@Param("alumnId") Long alumnId);

    @Query("SELECT t.id, SUM(s.corrects) FROM TextEntity t JOIN SolveEntity s ON t.id = s.solvedText.id JOIN AlumnEntity a ON a.id = s.alumnSolve.id JOIN GroupEntity g ON g.id = a.alumn_group.id WHERE g.group_teacher.id = :idGroup GROUP BY t.id ORDER BY SUM(s.corrects) DESC")
    List<Object[]> findMostEasiestTextsByTeacherId(@Param("idGroup") Long groupId);

    @Query("SELECT t.id, SUM(s.corrects) FROM TextEntity t JOIN SolveEntity s ON t.id = s.solvedText.id JOIN AlumnEntity a ON a.id = s.alumnSolve.id JOIN GroupEntity g ON g.id = a.alumn_group.id WHERE g.group_teacher.id = :idGroup GROUP BY t.id ORDER BY SUM(s.corrects) ASC")
    List<Object[]> findMostHardestTextsByTeacherId(@Param("idGroup") Long groupId);

    @Query("SELECT s.solvedText.id, COUNT(s.solvedText.id) FROM SolveEntity s JOIN AlumnEntity a ON a.id = s.alumnSolve.id JOIN GroupEntity g ON g.id = a.alumn_group.id JOIN TeacherEntity t ON t.id = g.group_teacher.id WHERE t.id = :idGroup GROUP BY s.solvedText.id ORDER BY COUNT(s.solvedText.id) DESC")
    List<Object[]> findMostReadTextsByTeacherId(@Param("idGroup") Long groupId);
}
