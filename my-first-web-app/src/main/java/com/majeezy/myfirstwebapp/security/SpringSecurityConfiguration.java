package com.majeezy.myfirstwebapp.security;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

	@Bean
	public InMemoryUserDetailsManager createUserDetails() {
		Function<String, String> passwordEncoder =  input -> passwordEncoder().encode(input);
		UserDetails user1 = createNewUser(passwordEncoder, "Majeezy", "password");
		UserDetails user2 = createNewUser(passwordEncoder, "Abdulmajeed", "idris");
		 return new InMemoryUserDetailsManager(user1, user2);
	}

	private UserDetails createNewUser(Function<String, String> passwordEncoder, String username, String password) {
		UserDetails user = User.builder().passwordEncoder(passwordEncoder)
				.username(username).password(password).roles("user", "admin").build();
		return user;
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(request-> request.anyRequest().authenticated());
    	http.formLogin(withDefaults());
    	http.csrf().disable();
    	http.headers().frameOptions().disable();
    	return http.build();
    }
}
