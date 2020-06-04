package com.ensa.e_banking.security;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	com.ensa.e_banking.security.jwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	

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
		public void configure(WebSecurity web) throws Exception {
		    web.ignoring()
		    .antMatchers("/compte/CC/{id}")
		    .antMatchers("/operation/recharge/{codeRecharge}")
		    .antMatchers("/operation/virement")
		    .antMatchers("/operation/listOperation/{id}");
		}

	
 
   
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("confi");

	        /*  http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic()
	          .and()
	          .logout().permitAll();*/
//		http.cors().disable();
				http.csrf().disable()
				 .authorizeRequests().anyRequest().authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		 .and()
		 /*.antMatchers("/login")*/

//		 .anyRequest()
//		 .permitAll()

//		 .authenticated()
		 .addFilter(new JWTAuthenticationFilter(authenticationManager()))
		 .addFilterBefore(new JWTAuthorizationFilter(),
		 UsernamePasswordAuthenticationFilter.class);

		/* http.csrf().disable()
		// don't create session
		
		 .authorizeRequests()
         .antMatchers("/login")
         .permitAll()
         .anyRequest()
         .authenticated()
		  .and()
		// make sure we use stateless session; session won't be used to
		// store user's state.
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager()))
		.addFilterBefore(new JWTAuthorizationFilter(),
				UsernamePasswordAuthenticationFilter.class);

		*/
		}
	          
	    
	          
		
	            
	    }
	
	


