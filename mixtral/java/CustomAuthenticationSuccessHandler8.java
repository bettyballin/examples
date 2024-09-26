import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        // Instantiate your object here
        Client client = new Client();

        ModelAndView view = new ModelAndView("home");

        // Add the instantiated object to model
        view.addObject("client", client);

        request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }
}

class Client {
    // Assume Client class has its properties and methods
}