package com.ensa.e_banking.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)

public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	private CustomAuthenticationEntryPoint unauthorizedHandler;
	

		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
		    return new BCryptPasswordEncoder();
		}
	
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			System.out.println("Quand");
			auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		}

	

	@Override
	
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("confi");
		 http.cors();
		 //ne pas utiliser les sessions pour gerer l'auth on va utiliser ls tokens
		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		/* http
	        .httpBasic()
	      .and()
	        .authorizeRequests()
	         .antMatchers(HttpMethod.OPTIONS,"*").permitAll()
	          .antMatchers("/").permitAll()
	          .anyRequest().authenticated()
	          .and().exceptionHandling().authenticationEntryPoint(unauthorizedHandler);*/
		 
		//addFilterBefore(new CustomAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
	          http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic()
	          .and().logout().permitAll();
	          http.csrf().disable();
		
	    }
	}
	


