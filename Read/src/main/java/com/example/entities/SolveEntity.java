package com.example.entities;


import jakarta.persistence.*;

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

    private @Getter int corrects;

    private @Getter int wrongs;

    private @Getter double nota;

    // Calificar solución
    public void calificar(){
        int totalRptas = this.corrects + this.wrongs;
        this.nota = ((double)totalRptas /20)*corrects;
    }
}
