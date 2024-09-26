import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;

import javax.servlet.http.HttpServletResponse;

public class Temp3402 {
    private static MessageSource messageSource;

    public static void main(String[] args) {
        // Simulate HttpSecurity object
        HttpSecurity http = new HttpSecurity();

        try {
            // Set unauthorized requests exception handler
            http = http.exceptionHandling().authenticationEntryPoint(
                    (request, response, ex) -> {
                        if (ex instanceof BadCredentialsException)
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                    messageSource.getMessage("error.authentication.badCredentials", null, LocaleContextHolder.getLocale()));
                        else if (ex instanceof InsufficientAuthenticationException)
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                    messageSource.getMessage("error.authentication.noAuthority", null, LocaleContextHolder.getLocale()));
                        else
                            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getLocalizedMessage());
                    }
            ).and();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Dummy classes to simulate Spring Security's HttpSecurity and ExceptionHandlingConfigurer
class HttpSecurity {
    ExceptionHandlingConfigurer exceptionHandling() {
        return new ExceptionHandlingConfigurer(this);
    }

    HttpSecurity and() {
        return this;
    }
}

class ExceptionHandlingConfigurer {
    private final HttpSecurity http;

    ExceptionHandlingConfigurer(HttpSecurity http) {
        this.http = http;
    }

    ExceptionHandlingConfigurer authenticationEntryPoint(AuthenticationEntryPoint entryPoint) {
        // Simulate setting the authentication entry point
        return this;
    }

    HttpSecurity and() {
        return http;
    }
}

interface AuthenticationEntryPoint {
    void commence(javax.servlet.http.HttpServletRequest request, HttpServletResponse response, Exception ex) throws java.io.IOException;
}