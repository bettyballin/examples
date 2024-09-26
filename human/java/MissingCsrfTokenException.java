import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class MissingCsrfTokenException extends RuntimeException {
}

/**
 * Post process the CsrfFilter to use a custom AccessDeniedHandler
 */
@Component
class CsrfFilterBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof CsrfFilter) {
            CsrfFilter csrfFilter = (CsrfFilter) bean;
            csrfFilter.setAccessDeniedHandler(new AccessDeniedHandler() {

                /**
                 * Default CsrfFilter AccessDeniedHandler implementation (org.springframework.security.web.access.AccessDeniedHandler)
                 */
                AccessDeniedHandler delegate = new AccessDeniedHandlerImpl();

                @Override
                public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

                    // test whether the request requires a valid CsrfToken (or is in training mode)
                    boolean inTrainingMode = false; // Set your condition here
                    if (inTrainingMode) {
                        throw new MissingCsrfTokenException();
                    } else {
                        // delegate to the default AccessDeniedHandler
                        delegate.handle(request, response, accessDeniedException);
                    }
                }
            });
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

/**
 * Custom Filter that logs the token-exceptions and continues the chain.
 */
class PreCsrfFilterFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(PreCsrfFilterFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (MissingCsrfTokenException ex) {
            // log and continue the filter chain
            logger.warn("No CSRF-Token found for {}", request.getRequestURI());
            filterChain.doFilter(request, response);
        }
    }
}

@Configuration
@EnableWebSecurity
class Config extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin().and()
                .httpBasic()
                .and()
                // add the custom filter before the CsrfFilter
                .addFilterBefore(new PreCsrfFilterFilter(), CsrfFilter.class);
    }
}