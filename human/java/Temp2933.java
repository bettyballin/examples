import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

@Controller
public class Temp2933 {

    @Autowired
    private IUserService service;

    @RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
    public String confirmRegistration(WebRequest request, Model model, @RequestParam("token") String token) {

        Locale locale = request.getLocale();

        VerificationToken verificationToken = service.getVerificationToken(token);
        if (verificationToken == null) {
            String message = "auth.message.invalidToken"; // Assuming messages is a placeholder, replace with actual message source 
            model.addAttribute("message", message);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();
        // Calendar cal = Calendar.getInstance();
        // if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
        //     String messageValue = messages.getMessage("auth.message.expired", null, locale);
        //     model.addAttribute("message", messageValue);
        //     return "redirect:/badUser.html?lang=" + locale.getLanguage();
        // }

        user.setEnabled(true);
        service.saveRegisteredUser(user);
        return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
    }
}

interface IUserService {
    VerificationToken getVerificationToken(String token);
    void saveRegisteredUser(User user);
}

class VerificationToken {
    private User user;
    // private Date expiryDate;

    public User getUser() {
        return user;
    }

    // public Date getExpiryDate() {
    //     return expiryDate;
    // }
}

class User {
    private boolean enabled;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}