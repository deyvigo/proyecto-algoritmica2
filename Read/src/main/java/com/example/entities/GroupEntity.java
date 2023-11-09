package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "grupos")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String groupName;

    @ManyToOne
    @JoinColumn(name = "group_teacher")
    private TeacherEntity group_teacher;

    @OneToMany(mappedBy = "alumn_group")
    private List<AlumnEntity> group_alumns;

}

