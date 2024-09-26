import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("approval")
public class ApprovalController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public ApprovalController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("confirm.do")
    public String get() {
        return "approval/confirm";
    }

    @PostMapping("confirm.do")
    public String post(@ModelAttribute ApprovalRequestForm form, Map<String, Object> model, Authentication authentication) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(form.getUsername(), form.getPassword());
        Authentication authenticate = authenticationManager.authenticate(token);

        if(authenticate.isAuthenticated() && isCurrentUser(authentication, authenticate)) {
            return "approval/success";
        }

        model.put("reason", "credentials doesn't belong to current user");
        return "approval/denied";
    }

    private boolean isCurrentUser(Authentication left, Authentication right) {
        return left.getName().equals(right.getName());
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception exception) {
        ModelAndView model = new ModelAndView("approval/denied");
        model.addObject("reason", exception.getMessage());
        return model;
    }

    public static class ApprovalRequestForm {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}