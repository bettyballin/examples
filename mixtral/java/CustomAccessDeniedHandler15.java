import org.springframework.context.annotation.Bean;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.ExceptionTranslationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SecurityConfig {

    @Bean
    public ExceptionTranslationFilter exceptionTranslationFilter() {
        return new ExceptionTranslationFilter(new CustomAuthenticationEntryPoint());
    }

    private class CustomAccessDeniedHandler implements AccessDeniedHandler {

        private String errorPage;

        public void setErrorPage(String errorPage) {
            this.errorPage = errorPage;
        }

        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response,
                           AccessDeniedException accessDeniedException) throws IOException, ServletException {

            if (this.errorPage != null && !response.isCommitted()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher(this.errorPage);

                try {
                    dispatcher.forward(request, response);
                } catch (Exception ex) {
                    throw new ServletException("Could not forward to error page", ex);
                }
            }
        }
    }

    @Bean
    public CustomAccessDeniedHandler accessDeniedHandler() {
        CustomAccessDeniedHandler customAccessDeniedHandler = new CustomAccessDeniedHandler();
        customAccessDeniedHandler.setErrorPage("/page_403");
        return customAccessDeniedHandler;
    }
}