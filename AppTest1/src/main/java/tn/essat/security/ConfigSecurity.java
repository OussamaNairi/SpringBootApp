package tn.essat.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter{
     
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder crypt=cryptMP();
		auth.inMemoryAuthentication().withUser("salah1").password(crypt.encode("essat")).roles("USER");
		auth.inMemoryAuthentication().withUser("fatma1").password(crypt.encode("essat")).roles("ADMIN","USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin();
		http.authorizeRequests().antMatchers("/ajout**/**","/delete**/**").hasRole("ADMIN");
		
		http.authorizeRequests().anyRequest().authenticated();
	}
	@Bean
	public PasswordEncoder cryptMP() {
		return new BCryptPasswordEncoder();
	}
}
