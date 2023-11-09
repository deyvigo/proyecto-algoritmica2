package com.example.utilities;

import com.example.entities.AlumnEntity;
import com.example.entities.RoleEntity;
import com.example.entities.TeacherEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.RoleRepository;
import com.example.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
/*

@Component
public class Runner implements CommandLineRunner {

    private AlumnRepository alumnRepository;
    private TeacherRepository teacherRepository;
    private RoleRepository roleRepository;

    public Runner(AlumnRepository alumnRepository, TeacherRepository teacherRepository, RoleRepository roleRepository) {
        this.alumnRepository = alumnRepository;
        this.teacherRepository = teacherRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(this.roleRepository.count() == 0){
            this.roleRepository.saveAll(List.of(
                    RoleEntity.builder().name(RoleName.ROLE_ALUMN).build(),
                    RoleEntity.builder().name(RoleName.ROLE_TEACHER).build()
            ));
        }

        if (this.alumnRepository.count() == 0){
            this.alumnRepository.saveAll(List.of(
                    AlumnEntity.builder()
                            .username("deyvi")
                            .password("1234")
                            .firstName("Deyvi")
                            .lastName("Gomez")
                            .alumn_rol(this.roleRepository.findByName(RoleName.ROLE_ALUMN).get())
                            .build()
            ));
        }

        if (this.teacherRepository.count() == 0){
            this.teacherRepository.saveAll(List.of(
                    TeacherEntity.builder()
                            .username("yeslynav")
                            .password("12345")
                            .firstName("Yesly")
                            .lastName("Navarro")
                            .profession("Economista")
                            .teacher_rol(this.roleRepository.findByName(RoleName.ROLE_TEACHER).get())
                            .build()
            ));
        }
    }
}
*/
