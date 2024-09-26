import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {

    private final UpdateUserClass updateUserClass;

    public MyController(UpdateUserClass updateUserClass) {
        this.updateUserClass = updateUserClass;
    }

    @RequestMapping(value = "requestName", method = RequestMethod.POST)
    public ModelAndView updateProcess(Authentication auth, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        //cast the Principal as your custom UserDetails
        CustomUserDetails cud = (CustomUserDetails) auth.getPrincipal();
        //ask a @Service class to process the new data and eventually update the user
        updateUserClass.updateUser(cud.whatYouNeed(), request);
        //if no error while processing then set ModelAndView to your "success page"
        if (updateUserClass.getErrors().isEmpty()) {
            mv.setViewName("successPage");
        }
        //else set ModelAndView to your "form page"
        //and, if you want, add the @Service class to show the
        //errors and other information in the form
        else {
            mv.setViewName("formPage");
            mv.addObject("form", updateUserClass);
        }
        return mv;
    }
}

class CustomUserDetails {
    // Assume appropriate fields and methods exist
    public Object whatYouNeed() {
        // Your implementation here
        return null;
    }
}

class UpdateUserClass {
    // Assume appropriate fields and methods exist

    public void updateUser(Object whatYouNeed, HttpServletRequest request) {
        // Your implementation here
    }

    public List<String> getErrors() {
        // Your implementation here
        return new ArrayList<>();
    }
}