package com.sdl.eazybank.config;

import com.sdl.eazybank.exceptions.BadRequestException;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collections;

import com.sdl.eazybank.filter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.server.csrf.CookieServerCsrfTokenRepository;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class ProjectSecurityConfig {

    private Logger logger = LoggerFactory.getLogger(ProjectSecurityConfig.class);

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity httpSecurity)
            throws Exception {
        httpSecurity
                .securityContext().requireExplicitSave(false).and()
                .cors().configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    configuration.setAllowedMethods(Collections.singletonList("*"));
                    configuration.setAllowCredentials(true);
                    configuration.setAllowedHeaders(Collections.singletonList("*"));
                    configuration.setMaxAge(3600L);
                    configuration.setExposedHeaders(Arrays.asList("Authorization"));
                    try {
                        //Todo if the request is not understood by the system 3 times the disable the user completely
                    } catch (Exception e) {
                        throw new BadRequestException("Invalid Url with exception " + e.getCause());
                    }
                    return configuration;
                }).and().csrf().ignoringAntMatchers("/api/")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .addFilterAfter(new CsrfFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTGeneratorFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JWTValidatorFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests((auth) ->
                        auth
//                                .antMatchers().hasAuthority("")
//                                .antMatchers().hasAuthority("")
//                                .antMatchers().hasAuthority("")
//                                .antMatchers().hasAuthority("")
                                .antMatchers("/app/v1/").authenticated()
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
