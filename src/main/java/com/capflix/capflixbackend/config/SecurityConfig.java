package com.capflix.capflixbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
				.authorizeHttpRequests((authz) ->
						authz.regexMatchers(HttpMethod.GET, "/user").permitAll()
								.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults());
		return http.build();

	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
				.username("jer")
				.password(passwordEncoder().encode("123"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("123"))
				.roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user, admin);
	}

//	@Bean
//	public WebSecurityCustomizer webSecurityCustomizer() {
//
//	}
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
//		configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
//		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}

	//
//	@Bean
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder()).withUser("fulano").password(passwordEncoder().encode("123")).roles("USER");
//	}

//	@Bean
//	public InMemoryUserDetailsManager userDetailsService() {
//
//		UserDetails user = User.builder()
//				.username("fulano")
//				.password("123")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(user);
//	}

}
