import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.server.WebFilter;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, WebFilter authenticationFilter) {
        return builder.routes()
            .route(r -> r.path("/my-service/**")
                .filters(f -> f.filter(authenticationFilter))
                .uri("http://localhost:8081"))
            .build();
    }

    @Bean
    public WebFilter authenticationFilter() {
        return (exchange, chain) -> {
            // Add your authentication logic here
            return chain.filter(exchange);
        };
    }
}