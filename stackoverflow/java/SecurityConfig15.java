import org.jetbrains.annotations.NotNull;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityConfig15 {

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/access-denied")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/**")
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .addFilterBefore(new WaffleWrapperSecurityBean(new GenericFilterBean()), BasicAuthenticationFilter.class);
    }

    public class WaffleWrapperSecurityBean extends GenericFilterBean {
        @NotNull
        private final GenericFilterBean wrappedFilter;

        public WaffleWrapperSecurityBean(GenericFilterBean filter) {
            wrappedFilter = filter;
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response,
                             FilterChain chain) throws IOException, ServletException {
            try {
                wrappedFilter.doFilter(request, response, chain);
            } catch (Exception e) {
                ((HttpServletResponse) response)
                        .sendRedirect("access-denied?message="
                                + URLEncoder.encode(e.getLocalizedMessage(), StandardCharsets.UTF_8.toString()));
            }
        }

        @Override
        public void destroy() {
            wrappedFilter.destroy();
        }
    }
}