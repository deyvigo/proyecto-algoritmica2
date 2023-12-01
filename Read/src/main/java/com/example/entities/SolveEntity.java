package com.example.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "solution")
public class SolveEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "solved_text")
    private TextEntity solvedText;

    @ManyToOne
    @JoinColumn(name = "alumn_solve")
    private AlumnEntity alumnSolve;

    private int corrects;

    private int wrongs;

    private double nota;

    @Temporal(TemporalType.DATE)
    private LocalDate dateOfSolution;

    // Calificar solución
    public void calificar(){
        int totalRptas = this.corrects + this.wrongs;
        this.nota = ((double)totalRptas /20)*corrects;
    }
}
