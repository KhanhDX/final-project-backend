package com.khanhdx.finalproject.config;


import com.khanhdx.finalproject.config.security.CustomUserDetailsService;
import com.khanhdx.finalproject.config.security.JwtAuthenticationEntryPoint;
import com.khanhdx.finalproject.config.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * Created by rajeevkumarsingh on 01/08/17.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean()
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // We don't need CSRF for this example
        httpSecurity
                .csrf()
                .disable()
                // dont authenticate these particular requests
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll()
                .antMatchers("/users/sign-up").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // all other requests need to be authenticated
                .anyRequest().fullyAuthenticated()
                .and()
                // make sure we use stateless session; session won't be used to
                // store user's state.
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
