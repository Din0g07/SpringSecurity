package com.dinogo.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder
                        .username("Dinogo")
                        .password("dinosaur")
                        .roles("MANAGER", "HR"))
                .withUser(userBuilder
                        .username("IrishkaChikiPiki")
                        .password("auf")
                        .roles("HR"))
                .withUser(userBuilder
                        .username("VovaZaebal")
                        .password("blyat")
                        .roles("EMPLOYEE"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info").hasRole("HR")
                .antMatchers("/manager_info").hasRole("MANAGER")
                .and().formLogin().permitAll();
    }
    //    @Bean
//    protected InMemoryUserDetailsManager userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("Dinogo")
//                .password("dinosaur")
//                .roles("MANAGER", "HR").build());
//
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("IrishkaChikiPiki")
//                .password("auf")
//                .roles("HR").build());
//
//        manager.createUser(User.withDefaultPasswordEncoder()
//                .username("VovaZaebal")
//                .password("blyat")
//                .roles("EMPLOYEE").build());
//
//        return manager;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeRequests(authorize -> authorize
//                        .anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return httpSecurity.build();
//    }
}

