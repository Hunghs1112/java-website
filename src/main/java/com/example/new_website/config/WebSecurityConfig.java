//package com.example.new_website.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
//
//@Configuration
//public class WebSecurityConfig {
//    @Bean
//    SecurityFilterChain configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth ->
//                auth
//                        .requestMatchers("/", "/home", "/about","/advice","/blog","/courses","/faq","/jobs","/materials", "/software","/training","/css/**", "/images/**").permitAll() // Permit access to these endpoints
//                        .anyRequest().authenticated()
//        );
//        http.csrf(CsrfConfigurer::disable);
//
//        return http.build();
//    }
//}

