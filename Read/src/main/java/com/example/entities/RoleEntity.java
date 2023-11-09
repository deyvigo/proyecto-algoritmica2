package com.example.entities;

import com.example.utilities.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    @OneToMany(mappedBy = "teacher_rol")
    private List<TeacherEntity> teachers;

    @OneToMany(mappedBy = "alumn_rol")
    private List<AlumnEntity> alumns;
}
