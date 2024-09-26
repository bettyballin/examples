import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class Temp1383 {

    public static void main(String[] args) {
        // Main method doesn't need to do anything for this example
    }

    @RequestMapping(value = "/acceptOffer", method = RequestMethod.POST)
    public ModelAndView acceptOffer(@ModelAttribute("offer") @Valid Offer offer, BindingResult bindingResult) {
        // Your code here
        return new ModelAndView("offerAccepted");
    }

    // Dummy Offer class for compilation
    public static class Offer {
        // Fields, getters, setters, etc.
    }
}