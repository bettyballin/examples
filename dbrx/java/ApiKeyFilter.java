Here is the corrected Java code:


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {
    private final ApiKeyRepository apiKeyRepository;

    @Autowired
    public ApiKeyFilter(ApiKeyRepository apiKeyRepository) {
        this.apiKeyRepository = apiKeyRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String apiKeyValue = request.getHeader("X-API-KEY");
        if (StringUtils.isEmpty(apiKeyValue)) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Missing API Key");
            return;
        }

        ApiKey apiKey = apiKeyRepository.findByApiKey(apiKeyValue);
        if (apiKey == null) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid API Key");
            return;
        }

        // Set the user ID as a request attribute for further use by controllers or services.
        request.setAttribute("userId", apiKey.getUserId());

        filterChain.doFilter(request, response);
    }
}

// Dummy ApiKey class for illustration purposes
class ApiKey {
    private String apiKey;
    private String userId;

    public ApiKey(String apiKey, String userId) {
        this.apiKey = apiKey;
        this.userId = userId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getUserId() {
        return userId;
    }
}

// Dummy ApiKeyRepository class for illustration purposes
interface ApiKeyRepository {
    ApiKey findByApiKey(String apiKey);
}

@Configuration
class FilterConfig {
    @Bean
    public FilterRegistrationBean apiKeyFilterRegistration(ApiKeyFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.addUrlPatterns("/*");
        return registration;
    }
}

Note that I've added a `@Configuration` class to register the filter using a `FilterRegistrationBean`, as the `@WebFilter` annotation is not compatible with Spring Boot. I've also added a constructor to the `ApiKey` class.