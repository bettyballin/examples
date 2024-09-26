import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.firewall.HttpFirewall;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@SpringBootApplication
public class Temp1753 {

    private static final Pattern HEADER_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9-]*$");

    public static void main(String[] args) {
        SpringApplication.run(Temp1753.class, args);
    }

    @Bean
    public FilterRegistrationBean<CustomHeaderValidationFilter> headerValidationFilter(SecurityProperties securityProperties) {
        SecurityProperties.Headers headers = securityProperties.getHeaders();

        Pattern headerNamePattern;
        if (headers.getName() != null && !headers.getName().isEmpty()) {
            // Use the provided pattern or create a new one.
            headerNamePattern = Pattern.compile(headers.getName());
        } else {
            headerNamePattern = HEADER_NAME_PATTERN;
        }

        FilterRegistrationBean<CustomHeaderValidationFilter> registrationBean = new FilterRegistrationBean<>();
        CustomHeaderValidationFilter filter = new CustomHeaderValidationFilter(headerNamePattern);
        registrationBean.setFilter(filter);

        return registrationBean;
    }

    static class CustomHeaderValidationFilter implements Filter {
        private final Pattern headerNamePattern;

        public CustomHeaderValidationFilter(Pattern headerNamePattern) {
            this.headerNamePattern = headerNamePattern;
        }

        @Override
        public void init(FilterConfig filterConfig) throws ServletException {
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            // Implement filter logic here
            chain.doFilter(request, response);
        }

        @Override
        public void destroy() {
        }
    }

    @Configuration
    public static class SecurityProperties {
        private Headers headers = new Headers();

        public Headers getHeaders() {
            return headers;
        }

        @ConfigurationProperties(prefix = "security.headers")
        public static class Headers {
            private String name;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}