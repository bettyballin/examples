import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Temp1909 {
    public static void main(String[] args) {
        // Simulating the HttpSecurity configuration
        // In a real Spring Security context, this would be configured in a SecurityConfig class extending WebSecurityConfigurerAdapter
        HttpSecurity http = new HttpSecurity();
        
        http.headers()
            .addHeaderWriter(new DelegatingRequestMatcherHeaderWriter(
                    new AntPathRequestMatcher("/javax.faces.resource/**"),
                    new HeaderWriter() {

                        @Override
                        public void writeHeaders(HttpServletRequest request,
                                                 HttpServletResponse response) {
                            response.addHeader("Cache-Control", "private, max-age=86400");
                        }
                    }))
            .defaultsDisabled();
    }

    // Mock HttpSecurity class for demonstration purposes
    static class HttpSecurity {
        HeadersConfigurer headersConfigurer = new HeadersConfigurer();

        public HeadersConfigurer headers() {
            return headersConfigurer;
        }

        // Mock HeadersConfigurer class
        static class HeadersConfigurer {
            public HeadersConfigurer addHeaderWriter(HeaderWriter headerWriter) {
                // Implement header writer addition logic here
                return this;
            }

            public HeadersConfigurer defaultsDisabled() {
                // Implement defaults disabling logic here
                return this;
            }
        }
    }
}