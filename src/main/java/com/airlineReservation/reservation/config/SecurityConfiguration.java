package com.airlineReservation.reservation.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import com.airlineReservation.reservation.dao.UserDao;
import com.airlineReservation.reservation.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

	@Autowired
	private com.airlineReservation.reservation.services.UserDetailServiceImp userDetailsService;
	
	@Autowired
	private com.airlineReservation.reservation.security.JwtAuthenticationEntryPoint handler;
	
	@Autowired
	private UserDao dao;
	
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .exceptionHandling().authenticationEntryPoint(handler).and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeHttpRequests()
        .requestMatchers("/auth/login")
          .permitAll()
          .requestMatchers("/auth/register")
          .permitAll()
          .requestMatchers("/cities")
          .permitAll()
          .requestMatchers("/ticket")
          .permitAll()
          .requestMatchers("/credit")
          .permitAll()
          .requestMatchers("/ticketske")
          .permitAll()
          .requestMatchers("/city")
          .permitAll()
          .requestMatchers("/tripsby")
          .permitAll()
          .requestMatchers("/trip")
          .permitAll()
          .requestMatchers("/trips")
          .permitAll()
          .requestMatchers("/tripsbyone")
          .permitAll()
          .requestMatchers(HttpMethod.GET,"/user")
          .permitAll()
          .requestMatchers(HttpMethod.DELETE,"/trip")
          .permitAll()
          .requestMatchers(HttpMethod.POST,"/credit")
          .permitAll()
          .requestMatchers(HttpMethod.POST,"/ticket")
          .permitAll()
        .anyRequest()
          .authenticated()
        .and()
        .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        
    ;

    return http.build();
  }
  
  
 

  public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
      authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
  }

  
  @Bean(BeanIds.AUTHENTICATION_MANAGER)
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    return config.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
