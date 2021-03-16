package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.persistence.criteria.CriteriaBuilder;

@Configuration
@EnableWebSecurity
public class SecurityAppConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityAppConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().
                anyRequest().authenticated().and().httpBasic();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService()  {
        UserDetails randomUser = User.builder()
                .username("secureUser")
                .password(passwordEncoder.encode("secured"))
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(randomUser);

    }
}
