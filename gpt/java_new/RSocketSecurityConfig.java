import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.rsocket.EnableRSocketSecurity;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity;
import org.springframework.security.rsocket.core.PayloadSocketAcceptorInterceptor;

@EnableRSocketSecurity
public class RSocketSecurityConfig {

    @Bean
    PayloadSocketAcceptorInterceptor rsocketInterceptor(RSocketSecurity rsocket) {
        rsocket
            .authorizePayload(authorize ->
                authorize
                    .route("protected.route.*").authenticated()
                    .anyExchange().permitAll()
            )
            .jwt(jwt ->
                jwt.authenticationManager(jwtReactiveAuthenticationManager())
            );
        return rsocket.build();
    }

    private Object jwtReactiveAuthenticationManager() {
        // Implement your JWT Reactive Authentication Manager here
        return null;
    }
}