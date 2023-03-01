package gestion.products.security;
 

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration 
public class SecurityConfig //extends WebSecurityConfigurerAdapter 
{
	 
	@Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
            .usersByUsernameQuery("SELECT username, password, enabled FROM users WHERE username=?")
            .authoritiesByUsernameQuery("SELECT username, authority FROM authorities WHERE username=?")
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // password : $2a$10$KJU4rZbVY6xOkKrWFSX4G.CPHlu7qCwKEGEOAVhvwQCBjjeZE8DKC
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
	        //.antMatchers("/clients").hasAuthority("ROLE_CLIENT")
	        .antMatchers("/products").hasRole("ADMIN")
	        //.antMatchers("/commandes").hasAuthority("ROLE_CLIENT") 
	        .antMatchers("/fournisseurs").hasAuthority("ROLE_ADMIN")
	        .antMatchers("/store").hasAnyAuthority("ROLE_CLIENT")
            //.anyRequest().authenticated()
            .and()		    //
            .httpBasic();   // 
        http.formLogin(//form -> form
    			//.loginPage("/login")
    			//.permitAll()
    		);   // demande pour afficher La page de login
        return http.build();
    }
	/*@Bean
    public UserDetailsManager users(DataSource dataSource) {
        UserDetails userd = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        JdbcUserDetailsManager user = new JdbcUserDetailsManager(dataSource);
        user.createUser(userd);
        return user;
    }*/
	
    /*@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build(); 
        return new InMemoryUserDetailsManager(user);
    }
    */
	/*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        auth.inMemoryAuthentication()
            .withUser(user);
    }*/
}
