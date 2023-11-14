package com.example.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;


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

    public String fullName (){
        return this.getFirstName() + " " + this.getLastName();
    }
}
