import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2LoginConfigurer;
import org.springframework.security.oauth2.core.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;

@SpringBootApplication
public class Temp1115 {

    public static void main(String[] args) {
        SpringApplication.run(Temp1115.class, args);
    }

    @Bean
    @Order(1)
    public WebSecurityConfigurerAdapter webSecurityConfigurerAdapter() {
        return new WebSecurityConfigurerAdapter() {

            @Autowired
            private ClientRegistrationRepository clientRegistrationRepository;

            @Override
            protected void configure(HttpSecurity http) throws Exception {
                OAuth2LoginConfigurer<HttpSecurity> login = new OAuth2LoginConfigurer<>();
                ClientRegistration registration = this.clientRegistrationRepository.findByRegistrationId("keycloak");
                if (registration != null) {
                    login.clientRegistration(registration)
                            .authorizationEndpoint()
                                .baseUri("/oauth2/authorize")
                                .and()
                            .tokenEndpoint()
                                .accessTokenResponseClient(new OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest>() {

                                    @Override
                                    public OAuth2AccessTokenResponse getTokenResponse(OAuth2AuthorizationCodeGrantRequest authorizationGrantRequest) {
                                        // Here you can implement your custom logic to get access token using Resource Owner Password Credentials Grant flow.
                                        return null;
                                    }
                                });
                }

                http.authorizeRequests()
                        .antMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().permitAll();
            }
        };
    }
}