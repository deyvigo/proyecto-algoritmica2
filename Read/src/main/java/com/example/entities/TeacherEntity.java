package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "teacher")
public class TeacherEntity extends UserEntity{

    private String profession;

    @ManyToOne
    @JoinColumn(name = "teacher_rol")
    private RoleEntity teacher_rol;

    @OneToMany(mappedBy = "group_teacher")
    private List<GroupEntity> teacher_groups;

}
