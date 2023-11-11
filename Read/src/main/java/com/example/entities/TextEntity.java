package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "texto")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TextEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @OneToMany(mappedBy = "text")
    private List<QuestionEntity> preguntas;

    @OneToMany(mappedBy = "solvedText")
    private List<SolveEntity> solutions;
}
