import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.BindingResult;
import javax.validation.Valid;

@Controller
public class OfferController {

    // Assuming offerService is already defined and autowired

    @RequestMapping(value = "/acceptOffer", method = RequestMethod.POST)
    public ModelAndView acceptOffer(@Valid @ModelAttribute("offer") Offer offer, @RequestParam("id") int id, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("acceptOffer");
            return modelAndView;
        }

        offerService.setId(id);
        offerService.saveOffer(offer);
        modelAndView.addObject("successMessage", "Offer accepted successfully!");
        modelAndView.setViewName("offerSuccess");

        return modelAndView;
    }
}