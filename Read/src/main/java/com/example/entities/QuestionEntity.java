package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "question")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pregunta;

    @OneToMany(mappedBy = "preg")
    private List<AlternativeEntity> alternativas;

    private String respuesta;

    @ManyToOne
    @JoinColumn(name = "text")
    private TextEntity text;
}
