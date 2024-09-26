// ApiEndpointConfiguration

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class ApiEndpointConfig {

    @Autowired
    private TokenAuthProvider tokenAuthProvider;

    @Autowired
    private TokenAuthFilter tokenAuthFilter;

    // ...

    @Bean
    @Order(1)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
            .requestMatcher(new AntPathRequestMatcher("/api/**"))
                .authorizeRequests((requests) -> requests.anyRequest().authenticated())
                   // configure your token-based authentication
                    .and()
                .apply(Customizer.withDefaults())
        .build();
    }
}

// OAuth2EndpointConfiguration

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AccessTokenResponseClient;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class OAuth2EndpointConfig {

    // ...

    @Autowired
    private OAuth2AccessTokenResponseClient oauth2AccessTokenResponseClient;

    @Bean
    @Order(2)
    public SecurityFilterChain oauth2SecurityFilterChain(HttpSecurity http, ClientRegistrationRepository clientRegistrations) throws Exception {
        return http
            .requestMatcher((matchers -> matchers.anyRequest()))
              // configure your OAuth2 authentication
             .oauth2Login()
             .tokenEndpoint().accessTokenResponseClient(this.oauth2AccessTokenResponseClient)
             .and().and().build();
    }
}