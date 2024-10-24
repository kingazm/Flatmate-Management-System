package com.kingazm.com.flatmate.system;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //Makes only the login page reachable when not logged in
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/", "/login", "..static/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/dashboard", true)
                        .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/logout"));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() { //TODO: get from database instead of plan text here!
        //responsible for retrieveing user details for login

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("lOdwoEx^7SAA")
                .roles("ADMIN")
                .build();

        UserDetails user1 = User.withDefaultPasswordEncoder()
                .username("Kinga")
                .password("1")
                .roles("USER")
                .build();

        UserDetails user2 = User.withDefaultPasswordEncoder()
                .username("Martyna")
                .password("2")
                .roles("USER")
                .build();

        UserDetails user3 = User.withDefaultPasswordEncoder()
                .username("Aleks")
                .password("3")
                .roles("USER")
                .build();

        UserDetails user4 = User.withDefaultPasswordEncoder()
                .username("TestRoommate")
                .password("Test")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user1, user2, user3, user4);
    }
}
