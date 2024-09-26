import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = {AdminController.class, Controller.class})
public class SessionScope {

    @Autowired
    private UserService userService;

    // This method will be called for every request
    @ModelAttribute("user")
    public void setUserInModel(HttpServletRequest httpServletRequest) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && !"anonymousUser".equalsIgnoreCase(authentication.getName())) {
            User user = userService.findByEmail((String) authentication.getPrincipal());

            // Set the authenticated user in model
            httpServletRequest.setAttribute("user", user);
        }
    }
}