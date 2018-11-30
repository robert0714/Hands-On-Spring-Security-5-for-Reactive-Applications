package com.packtpub.book.ch07.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity(debug = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled  from users where username = ?")
				.authoritiesByUsernameQuery("select username, authority  from authorities where username = ?")
				.passwordEncoder(new BCryptPasswordEncoder());
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	
    	//p.214 
//		http.csrf().disable();
		
		//p.215 To persist the CSRF token. 
//		http.csrf().csrfTokenRepository(new CookieCsrfTokenRepository());
		
        //p.212, Session management: Session creation policy
//       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
        
        //p.212, Session management: Invalid session handling
//        http.sessionManagement().invalidSessionUrl("/invalidSession");
        
        //p.212 Session management: Session fixation approaches
//        http.sessionManagement().sessionFixation().migrateSession();
        
        //p.212, Session management:  Concurrent sessions controlled to maximum of 1
//        http.sessionManagement().maximumSessions(1);

      // FIXME: TODO: Allow anyone to use H2 (NOTE: NOT FOR PRODUCTION USE EVER !!! )
        http.authorizeRequests()
        .antMatchers("/admin/h2/**").permitAll() .and().authorizeRequests() .antMatchers("/").hasAnyRole("ADMIN", "USER")
          
            .and()
            .httpBasic(); //Use Basic authentication
        
        // Enable <frameset> in order to use H2 web console
          http.headers().frameOptions().disable();
    }

    @Bean
    public PersistentTokenRepository tokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl=new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        return jdbcTokenRepositoryImpl;
    }
}
