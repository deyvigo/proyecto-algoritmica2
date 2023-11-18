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

    //Obtener promedio
    public double calcularPromedio() {
        if (solutions.isEmpty()) {
            return 0.0;
        }

        double sumaNotas = solutions.stream().mapToDouble(SolveEntity::getNota).sum();
        return sumaNotas / solutions.size();
    }
    public double calcularPromedioPreguntasCorrectasPorTexto() {
        int totalPreguntas = solutions.stream()
                .mapToInt(solve -> solve.getCorrects() + solve.getWrongs())
                .sum();
        
        int totalCorrectas = solutions.stream()
                .mapToInt(SolveEntity::getCorrects)
                .sum();

        return totalPreguntas > 0 ? ((double) totalCorrectas / totalPreguntas) * 100 : 0;
    }

    public double calcularPorcentajeTextosAcertadosCompletamente() {
        if (solutions.isEmpty()) {
            return 0.0;
        }
        long textosAcertadosCompletamente = solutions.stream()
                .filter(solve -> solve.getNota() == 20)
                .count();

        return (double) textosAcertadosCompletamente / solutions.size() * 100;
    }

    public double calcularPorcentajeTextosFalladosCompletamente() {
        if (solutions.isEmpty()) {
            return 0.0;
        }
        long textosFalladosCompletamente = solutions.stream()
                .filter(solve -> solve.getNota() == 0)
                .count();

        return (double) textosFalladosCompletamente / solutions.size() * 100;
    }
}
