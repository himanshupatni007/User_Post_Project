package com.codewithhimanshu.blog.config;

import com.codewithhimanshu.blog.security.JWTAuthenticationEntryPoint;
import com.codewithhimanshu.blog.security.JWTAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Security {
    @Autowired
    private JWTAuthenticationEntryPoint point;
    @Autowired
    private JWTAuthenticationFilter filter;

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable).
                cors(AbstractHttpConfigurer::disable).
                authorizeHttpRequests(auth->auth.requestMatchers("/api/auth/login").permitAll()
                        .anyRequest().authenticated())
                        .exceptionHandling(ex->ex.authenticationEntryPoint(point)).
                sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));



        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    private void authenticate(String email,String password){
       UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(email,password);

    }
}
