import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.security.web.authentication.AuthenticationTrustResolver;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Temp578 {

    @Autowired
    private AuthenticationTrustResolver authenticationTrustResolver;

    @GetMapping("/login")
    public String showLoginForm(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (authenticationTrustResolver.isAnonymous(SecurityContextHolder.getContext().getAuthentication())) {
            // User is not authenticated
            return "login";
        } else {
            SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(request, response);
            if (savedRequest != null) {
                String targetUrl = savedRequest.getRedirectUrl();
                // Redirect to the original requested URL
                return "redirect:" + targetUrl;
            } else {
                // User is authenticated and remember-me enabled redirect them to homepage
                return "redirect:/home";
            }
        }
    }
}