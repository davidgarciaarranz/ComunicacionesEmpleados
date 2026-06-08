package com.practica.hetero3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfigurationMode {

    @Bean
    public InMemoryUserDetailsManager userDetailsService(final PasswordEncoder passwordEncoder) {
        final UserDetails user = User.withUsername("usuario")
                .password(passwordEncoder.encode("contraseña")).roles("USER").build();

        final UserDetails admin = User.withUsername("administrador")
                .password(passwordEncoder.encode("admin")).roles("USER", "ADMIN").build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        http
                // Desactivamos CSRF usando la nueva sintaxis de lambdas
                .csrf(AbstractHttpConfigurer::disable)
                // Configuramos la autorización de peticiones
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated())
                // Activamos Basic Auth con la configuración por defecto
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
