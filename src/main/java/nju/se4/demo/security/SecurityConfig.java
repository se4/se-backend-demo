package nju.se4.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    private final SecurityUserController securityUserController;

    @Autowired
    public SecurityConfig(SecurityUserController securityUserController) {
        this.securityUserController = securityUserController;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JWTLoginFilter loginFilter = new JWTLoginFilter(authenticationManager());
        loginFilter.setAuthenticationFailureHandler(new AuthFailHandler());
        loginFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/vX/authorization/login", "POST"));
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager(), securityUserController, new RestAuthorEntry());

//        http.addFilterAfter(loginFilter, UsernamePasswordAuthenticationFilter.class);
        http
//                .httpBasic().and()
                .cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/vX/authorization/register").permitAll()
                .antMatchers("/api/vX/user").hasRole("STUDENT")
//                .antMatchers("/worker/**").hasRole("WORKER")
                .anyRequest().permitAll()
                .and()
                .addFilterAfter(loginFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilter(jwtAuthenticationFilter);


//                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("ym").password("{noop}123").roles("MAN");
        auth.userDetailsService(securityUserController);
    }
}

