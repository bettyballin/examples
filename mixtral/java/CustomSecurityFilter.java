import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;
import org.springframework.http.HttpHeaders;
import org.springframework.util.CollectionUtils;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Component
public class CustomSecurityFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String subdomain = getSubDomainFromRequestUrlOrHeader(exchange);

        if ("test".equalsIgnoreCase(subdomain)) {
            // Enable security for this request
            exchange.getAttributes().put("enableSecurity", true);
        } else {
            // Disable security for other requests
            exchange.getAttributes().put("enableSecurity", false);
        }

        return chain.filter(exchange);
    }

    private String getSubDomainFromRequestUrlOrHeader(ServerWebExchange exchange) {
        HttpHeaders headers = exchange.getRequest().getHeaders();

        List<String> baseURLs = headers.get("base-url");

        if (!CollectionUtils.isEmpty(baseURLs)) {
            String[] splitBaseUrl = baseURLs.get(0).split("/")[2].split("\\.");

            return splitBaseUrl[0];
        }

        // If not found in header extract from request URL
        URI uri = exchange.getRequest().getURI();

        String hostName = uri.getHost();

        if (hostName != null) {
            return Arrays.stream(hostName.split("\\.")).findFirst().orElse("");
        }

        // Return empty string or default value
        return "";
    }
}