package com.a1st.invoicepro.configuration;

import com.a1st.invoicepro.filter.CustomAuthorizationFilter;
import com.a1st.invoicepro.handler.CustomAccessDeniedHandler;
import com.a1st.invoicepro.handler.CustomAuthenticationEntryPoint;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.DELETE;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

/**
 * @author: Abderrahman Youabd aka: A1ST
 * @version: 1.0
 */

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final BCryptPasswordEncoder encoder;
    private final CustomAccessDeniedHandler customAccessDeniedHandler;
    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
    private final UserDetailsService userDetailsService;
    private final CustomAuthorizationFilter customAuthorizationFilter;

    private static final String[] PUBLIC_URLS = { "/user/login/**", "/user/register", "/user/verify/code/**", "/user/reset-password/**", "/user/verify/password/**", "/user/verify/account/**" };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable().cors().disable();
//        http.sessionManagement().sessionCreationPolicy(STATELESS);
//        http.authorizeHttpRequests().requestMatchers(PUBLIC_URLS).permitAll();
//        http.authorizeHttpRequests().requestMatchers(DELETE, "/user/delete/**").hasAnyAuthority("DELETE:USER");
//        http.authorizeHttpRequests().requestMatchers(DELETE, "/customer/delete/**").hasAnyAuthority("DELETE:CUSTOMER");
//        http.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler).authenticationEntryPoint(customAuthenticationEntryPoint);
//        http.authorizeHttpRequests().anyRequest().authenticated();
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable);
        http.sessionManagement(session -> session.sessionCreationPolicy(STATELESS));
        http.authorizeHttpRequests(request -> request.requestMatchers(PUBLIC_URLS).permitAll());
        http.authorizeHttpRequests(request -> request.requestMatchers(DELETE, "/user/delete/**").hasAuthority("DELETE:USER"));
        http.authorizeHttpRequests(request -> request.requestMatchers(DELETE, "/customer/delete/**").hasAuthority("DELETE:CUSTOMER"));
        http.exceptionHandling(exception -> exception.accessDeniedHandler(customAccessDeniedHandler).authenticationEntryPoint(customAuthenticationEntryPoint));
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.addFilterBefore(customAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder);
        return new ProviderManager(authProvider);
    }

    /* Documentations
    https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/web/authentication/UsernamePasswordAuthenticationFilter.html

    https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/authentication/AuthenticationManager.html

    https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/authentication/AuthenticationProvider.html

    https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/authentication/dao/DaoAuthenticationProvider.html

    https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/authentication/dao/AbstractUserDetailsAuthenticationProvider.html
    */
}


















