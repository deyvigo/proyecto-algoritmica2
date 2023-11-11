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
@Table(name = "alumn")
public class AlumnEntity extends UserEntity{

    private double nota;

    @ManyToOne
    @JoinColumn(name = "alumn_rol")
    private RoleEntity alumn_rol;

    @ManyToOne
    @JoinColumn(name = "alumn_group")
    private GroupEntity alumn_group;

    @OneToMany(mappedBy = "alumnSolve")
    private List<SolveEntity> solutions;
}
