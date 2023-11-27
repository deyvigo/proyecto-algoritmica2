package com.example.repositories;

import com.example.entities.AlumnEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnRepository extends JpaRepository<AlumnEntity, Long> {
    Optional<AlumnEntity> findByUsername(String username);

    @Query("SELECT a FROM AlumnEntity a WHERE a.alumn_group.id = :groupId")
    List<AlumnEntity> getAlumnsPerGroup(@Param("groupId") Long groupId);    
}
