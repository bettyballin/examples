import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Assuming this is within a method where `http` is of type HttpSecurity or similar
HeadersConfigurer<?> httpHeadersConfigurer = http.headers();
httpHeadersConfigurer.addHeaderWriter(new DelegatingRequestMatcherHeaderWriter(
        new AntPathRequestMatcher("/javax.faces.resource/**"),
        new HeaderWriter() {
            @Override
            public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
                response.addHeader("Cache-Control", "private, max-age=86400");
            }
        }