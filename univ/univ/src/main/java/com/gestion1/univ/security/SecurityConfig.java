package com.gestion1.univ.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.formLogin(Customizer.withDefaults());
        return  httpSecurity.build();
    }
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(){
        return new InMemoryUserDetailsManager(User.withUsername("admin").password("{noop}123").roles("ADMIN").build(),
                User.withUsername("etudiant").password("123").roles("ETUDIANT").build(),
                User.withUsername("enseignant").password("123").roles("ENSEIGNANT").build()


                );

    }
}
