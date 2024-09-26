import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;

// Assume CustomUserDetails and UpdateUserClass are defined elsewhere
// import your.package.CustomUserDetails;
// import your.package.UpdateUserClass;

public class YourController6 {
    
    private UpdateUserClass updateUserClass; // Assume this is autowired or properly instantiated
    
    @RequestMapping(value = "requestName", method = RequestMethod.POST)
    public ModelAndView updateProcess(Authentication auth, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        CustomUserDetails cud = (CustomUserDetails) auth.getPrincipal();
        updateUserClass.updateUser(cud.getWhatYouNeed(), request);
        if (updateUserClass.getErrors().isEmpty()) {
            mv.setViewName("successPage");
        } else {
            mv.setViewName("formPage");
            mv.addObject("form", updateUserClass);
        }
        return mv;
    }
}