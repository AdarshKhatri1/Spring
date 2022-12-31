package com.adarsh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class MySecurityConfig {

	
	
	@Bean
	public InMemoryUserDetailsManager userDetails() {
		
		InMemoryUserDetailsManager userDetails = new InMemoryUserDetailsManager();
		
		UserDetails admin = User.withUsername("admin").password("12345").authorities("admin").build();
		UserDetails user = User.withUsername("user").password("1234").authorities("user").build();
		
		userDetails.createUser(admin);
		userDetails.createUser(user);
		return userDetails;
	}
	
	// when you use InMemoryUserDetailsManager then password encoder is compulsory
	
	@Bean
	public PasswordEncoder encodepassword() {
		return NoOpPasswordEncoder.getInstance(); //not recommended
	}
	
	@Bean
	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((auth) ->auth		
				.requestMatchers("/masai/user/home","/masai/user/dashboard").hasAuthority("user")
				.requestMatchers("/masai/admin/home","/masai/admin/dashboard").hasAuthority("admin")
				.requestMatchers("/masai/home").permitAll()	
				).httpBasic();	
		
		return http.build();
	}
	
//	@Bean
//	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
//		
//		http.authorizeHttpRequests((auth) ->auth		
//				.requestMatchers("/masai/user/home","/masai/user/dashboard").authenticated()
//				.requestMatchers("/masai/admin/home","/masai/admin/dashboard").authenticated()
//				.requestMatchers("/masai/home").permitAll()	
//		).httpBasic();	
//		
//		return http.build();
//	}
	
	
}
