package com.example.services;

import com.example.entities.AlumnEntity;
import com.example.entities.TeacherEntity;
import com.example.repositories.AlumnRepository;
import com.example.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AlumnRepository alumnRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AlumnEntity alumn = alumnRepository.findByUsername(username)
                .orElse(null);
        if (alumn != null){
            Collection<? extends GrantedAuthority> autority = Collections.singleton(new SimpleGrantedAuthority(alumn.getAlumn_rol().getName().toString()));
            return new User(alumn.getUsername(),
                    alumn.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    autority);
        } else {
            TeacherEntity teacher = teacherRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("EL usuario " + username + " no está regustrado."));
            Collection<? extends GrantedAuthority> autority = Collections.singleton(new SimpleGrantedAuthority(teacher.getTeacher_rol().getName().toString()));
            return new User(teacher.getUsername(),
                    teacher.getPassword(),
                    true,
                    true,
                    true,
                    true,
                    autority);
        }
    }
}
