package com.sdl.eazybank.config;

import com.sdl.eazybank.exceptions.BadRequestException;
import java.security.Principal;
import java.util.Collections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class ProjectSecurityConfig {

  private Logger logger = LoggerFactory.getLogger(ProjectSecurityConfig.class);
  @Bean
  public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity)
      throws Exception {
    httpSecurity
        .cors().configurationSource(request -> {
          CorsConfiguration configuration = new CorsConfiguration();
          configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
          configuration.setAllowedMethods(Collections.singletonList("*"));
          configuration.setAllowCredentials(true);
          configuration.setAllowedHeaders(Collections.singletonList("*"));
          configuration.setMaxAge(3600L);
          try{
            //Todo if the request is not understood by the system 3 times the disable the user completely
          }catch (Exception e){
            throw new BadRequestException("Invalid Url with exception "+ e.getCause());
          }
          return configuration;
        }).and().csrf().disable()
        .authorizeHttpRequests((auth) ->
            auth.antMatchers("/app/v1/").authenticated()
                .antMatchers("/api/")
                .permitAll())
        .httpBasic(Customizer.withDefaults());
    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
