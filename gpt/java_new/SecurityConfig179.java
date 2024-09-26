public class SecurityConfig179 {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            .authorizeExchange()
            .anyExchange().authenticated()
            .and()
            .oauth2Login();
        return http.build();
    }

    @Bean
    public ServerOAuth2AuthorizedClientRepository authorizedClientRepository() {
        // Implementation of ServerOAuth2AuthorizedClientRepository
        // This is just a placeholder, actual implementation should be provided
        return new InMemoryServerOAuth2AuthorizedClientRepository();
    }
}

// Placeholder for the actual implementation of ServerOAuth2AuthorizedClientRepository
class InMemoryServerOAuth2AuthorizedClientRepository implements ServerOAuth2AuthorizedClientRepository {
    // Implement the required methods for ServerOAuth2AuthorizedClientRepository
}