package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alternative")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AlternativeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String alternativa;

    @ManyToOne
    @JoinColumn(name = "preg")
    private QuestionEntity preg;
}
