package com.floresyeventos.v1.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.floresyeventos.v1.Service.UserService;
import com.floresyeventos.v1.Service.UserServiceImpl;

@Configuration
public class SecurityConfig {

    private final UserServiceImpl userService;

    public SecurityConfig(UserServiceImpl userService) {
        this.userService = userService;
    }

@Bean
public UserDetailsService userDetailsService() {
    return userService;
}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/error").permitAll()
                
                .requestMatchers("/", 
                "/home/**", 
                "/register/**", 
                "/error/**", 
                "/images/**").permitAll() 
                .requestMatchers("/doc/**", "/swagger-ui/**", "/swagger-ui.html").permitAll() // Rutas públicas
                .requestMatchers("/flores/**").authenticated() // Rutas protegidas
                
            )
            .formLogin(form -> form
                .loginPage("/home/login")                          // Página personalizada de login
                .defaultSuccessUrl("/home/index", true)                     // Redirección tras login exitoso
                .permitAll()
            )
          
          
            .logout(logout -> logout
                .logoutUrl("/logout")                             // URL para cerrar sesión
                .logoutSuccessUrl("/login?logout=true")           // Redirección tras logout
                .invalidateHttpSession(true)                     // Invalida la sesión
                .deleteCookies("JSESSIONID")                     // Borra cookies de sesión
                .permitAll()
            )
           .userDetailsService(userService); // Configuración para autenticar desde la base de datos
    
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }


}
