package com.nara.user_service.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

  @Autowired
  JwtAuthFilter JwtAuthFilter; // add this later

  // add the security dependency later to make this portion work
  @Bean
  public SecurityFilterChain SecurityFilterChain(HttpSecurity http) {
    return http
        .authorizeHttpRequest(auth -> auth.anyRequest().authenticate())
        .addFilterBefore(JwtAuthFilter, UsernamePasswordAuthenticationFilter.class)// this comes from security
                                                                                   // dependency
        .build();
  }

}
