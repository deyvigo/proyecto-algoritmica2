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

    @Column(columnDefinition = "TEXT")
    private String pregunta;

    @OneToMany(mappedBy = "preg")
    private List<AlternativeEntity> alternativas;

    @Column(columnDefinition = "TEXT")
    private String respuesta;

    @Column(columnDefinition = "TEXT")
    private String razonamiento;

    @ManyToOne
    @JoinColumn(name = "text")
    private TextEntity text;
}
