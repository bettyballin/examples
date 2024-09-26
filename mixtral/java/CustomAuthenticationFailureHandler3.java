import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@Component("authenticationFailureHandler")
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Autowired
    private MessageSource messages;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        if (exception.getMessage().equalsIgnoreCase("User is disabled")) {
            setDefaultFailureUrl("/notconfirm");
        } else {
            setDefaultFailureUrl("/login?error=true");
        }

        super.onAuthenticationFailure(request, response, exception);

        Locale locale = request.getLocale();

        String errorMessage;

        if (exception instanceof BadCredentialsException) {
            errorMessage = messages.getMessage("message.badCredentials", null, locale);
        } else if (exception.getClass().isAssignableFrom(DisabledException.class)) {
            // Handle disabled user exception
            errorMessage = messages.getMessage("auth.message.disabled", null, locale);
            request.getSession().setAttribute("error_msg", "User is Disabled");
        } else if (exception instanceof LockedException) {
            errorMessage = messages.getMessage("auth.message.locked", null, locale);
            request.getSession().setAttribute("error_msg", "Account locked due to multiple failed login attempts.");
        } else {
            // Handle other exceptions
            errorMessage = exception.getMessage();
            request.getSession().setAttribute("error_msg", errorMessage);
        }
    }
}