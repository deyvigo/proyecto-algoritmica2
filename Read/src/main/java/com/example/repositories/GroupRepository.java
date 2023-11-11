package com.example.repositories;

import com.example.entities.GroupEntity;
import lombok.NonNull;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<GroupEntity, Long> {

    @Override
    @NonNull
    @Query("SELECT g FROM GroupEntity g JOIN g.group_teacher t ORDER BY t.username")
    List<GroupEntity> findAll();

    Optional<GroupEntity> findByGroupName(String name);


    @Override
    @NonNull
    @Query("SELECT g FROM GroupEntity g WHERE g.id = :id")
    Optional<GroupEntity> findById(@NonNull @Param("id")Long id);

    @Query("SELECT g FROM GroupEntity g JOIN g.group_teacher t WHERE t.username = :username")
    List<GroupEntity> findByTeacherUsername(@Param("username") String username);
}
