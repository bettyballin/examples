import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class Temp1382 {

    public static void main(String[] args) {
        // Spring Boot application entry point
    }

    @RequestMapping(value = "/acceptOffer", method = RequestMethod.POST)
    public ModelAndView acceptOffer(@ModelAttribute("offer") @Valid Offer offer, BindingResult bindingResult,
                                    @RequestParam String id) {
        // Your code here
        return new ModelAndView("offerAccepted");
    }
    
    public static class Offer {
        // Example fields
        private String name;
        private String description;

        // Getters and setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}