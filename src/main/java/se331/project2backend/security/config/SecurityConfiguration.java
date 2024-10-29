package se331.project2backend.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//
//        http.headers((headers) -> headers.frameOptions().disable())
//                .csrf().disable()
//                .cors() // Ensure this is before authorizeHttpRequests
//                .and()
//                .authorizeHttpRequests((authorize) -> {
//                    authorize.requestMatchers("/api/v1/auth/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/events/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/countries/**").permitAll()
//                            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                            .anyRequest().authenticated();
//                })
//                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .logout((logout) -> {
//                    logout.logoutUrl("/api/v1/auth/logout");
//                    logout.addLogoutHandler(logoutHandler);
//                    logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
//                });
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:5173");  // Frontend origin
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.addExposedHeader("Authorization");
//        config.addExposedHeader("Content-Type");
//        config.addExposedHeader("x-total-count");
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}


//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.headers((headers) -> headers.frameOptions().disable())
//                .csrf().disable()
//                .cors() // Ensure this is before authorizeHttpRequests
//                .and()
//                .authorizeHttpRequests((authorize) -> {
//                    authorize.requestMatchers("/api/v1/auth/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/events/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/countries/**").permitAll()
//                            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                            // Add admin user management endpoints
//                            .requestMatchers("/api/v1/users/**").hasRole("ADMIN") // Only admins can access
//                            .anyRequest().authenticated();
//                })
//                .sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .logout((logout) -> {
//                    logout.logoutUrl("/api/v1/auth/logout");
//                    logout.addLogoutHandler(logoutHandler);
//                    logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
//                });
//
//        return http.build();
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:5173");  // Frontend origin
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.addExposedHeader("Authorization");
//        config.addExposedHeader("Content-Type");
//        config.addExposedHeader("x-total-count");
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}

//

//    private final JwtAuthenticationFilter jwtAuthFilter;
//    private final AuthenticationProvider authenticationProvider;
//    private final LogoutHandler logoutHandler;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.headers(headers -> headers.frameOptions().disable())
//                .csrf().disable()
//                .cors()
//                .and()
//                .authorizeHttpRequests(authorize -> {
//                    authorize.requestMatchers("/api/v1/auth/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/events/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/countries/**").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/api/v1/auth/authenticate").permitAll()
//                            .requestMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
//                            .requestMatchers(HttpMethod.POST, "/api/events/api/update-sports").hasRole("ADMIN")
//                            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                            .requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
//                            .anyRequest().authenticated();
//                })
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
//                .logout(logout -> {
//                    logout.logoutUrl("/api/v1/auth/logout");
//                    logout.addLogoutHandler(logoutHandler);
//                    logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
//                });
//
//        return http.build();
//    }

    //    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:5173");  // Frontend origin
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.addExposedHeader("Authorization");
//        config.addExposedHeader("Content-Type");
//        config.addExposedHeader("Config");
//        config.addExposedHeader("x-total-count");
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//
//        config.setAllowCredentials(true);
//        config.addAllowedOrigin("http://localhost:5173");  // Your frontend origin
//        config.addAllowedHeader("*");
//        config.addAllowedMethod("*");
//        config.addExposedHeader("Authorization");
//        config.addExposedHeader("Content-Type");
//        config.addExposedHeader("x-total-count");
//
//        source.registerCorsConfiguration("/**", config);
//        return new CorsFilter(source);
//    }
//}

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .headers(headers -> headers.frameOptions().disable())
                .csrf().disable()
                .cors() // Ensure this is before authorizeHttpRequests
                .and()
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/api/v1/auth/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/events/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/countries/**").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/v1/auth/authenticate").permitAll()
                            .requestMatchers(HttpMethod.POST, "/api/countries/add-with-events").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.POST, "/api/v1/update-sports").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                            .requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
                            .anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout -> {
                    logout.logoutUrl("/api/v1/auth/logout");
                    logout.addLogoutHandler(logoutHandler);
                    logout.logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
                });

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:5173");  // Your frontend origin
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Authorization");
        config.addExposedHeader("Content-Type");
        config.addExposedHeader("x-total-count");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}