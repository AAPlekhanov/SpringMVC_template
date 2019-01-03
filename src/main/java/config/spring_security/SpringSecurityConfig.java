package config.spring_security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * настройки для Spring security
 */

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user").roles("user").and()
                .withUser("admin").password("{noop}admin").roles("admin");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
     http.authorizeRequests().mvcMatchers("/test").authenticated().and().httpBasic().and().formLogin();
    }
}
