import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Temp3092 {

    private final UpdateUserService updateUserService;

    public Temp3092(UpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView updateProcess2(Authentication auth, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        PrincipalUser pu = (PrincipalUser) auth.getPrincipal();
        updateUserService.updateUser2(pu.getUser(), request);
        if (updateUserService.getErrors().isEmpty()) {
            mv.setViewName("members/userProfile");
            mv.addObject("page", "userProfile");
        } else {
            mv.setViewName("members/userUpdate");
            mv.addObject("page", "userProfile");
            mv.addObject("form", updateUserService);
        }
        return mv;
    }

    public static void main(String[] args) {
        // This method can be used for testing purposes
        // Spring Boot applications are typically started in a different way
    }
}

// Assuming these classes exist
class PrincipalUser {
    public User getUser() {
        return new User();
    }
}

class User {
}

interface UpdateUserService {
    void updateUser2(User user, HttpServletRequest request);

    java.util.List<String> getErrors();
}