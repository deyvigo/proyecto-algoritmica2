package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.time.Period;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    private int age;

    public String fullName (){
        return this.getFirstName() + " " + this.getLastName();
    }

    public int calculateAge(){
        LocalDate now = LocalDate.now();
        Period period = Period.between(this.getBirthDate(), now);
        return period.getYears();
    }
}
