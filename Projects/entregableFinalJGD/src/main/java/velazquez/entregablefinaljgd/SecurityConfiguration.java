package velazquez.entregablefinaljgd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import velazquez.entregablefinaljgd.services.JPAUserDetailsService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    JPAUserDetailsService userDetailsService;

    @Bean
    public AuthenticationManager authenticationManagerBean(HttpSecurity httpSec) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                httpSec.getSharedObject(AuthenticationManagerBuilder.class);

        authenticationManagerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(getPasswordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception {
        httpSec
                .authorizeHttpRequests(
                        authz ->
                                authz
                                        .requestMatchers("/", "/register", "/logout")
                                        .permitAll()
                                        .requestMatchers( "/grados", "/grados/*", "/estudiantes/*", "/usuarios", "usuarios/*")
                                        .hasRole("ADMIN")
                                        .requestMatchers("/profesores", "/profesores/*")
                                        .hasRole("USER")
                                        .requestMatchers("/register")
                                        .anonymous()
                )
                .formLogin(form -> form.loginPage("/login").permitAll())
                .logout(logout -> logout.logoutUrl("/logout").permitAll())
                .httpBasic(withDefaults());
        return httpSec.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(15);
    }
}

