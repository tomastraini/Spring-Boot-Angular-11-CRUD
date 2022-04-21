package com.example.CRUD.Configurations;

import com.example.CRUD.Models.Usuarios;
import com.example.CRUD.Repositories.UsuariosRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    public UsuariosRepo repo;
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.csrf().disable();
    }

}