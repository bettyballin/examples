import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Temp3626 {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{customerId}")
    public String getCustomer(Model theModel, @PathVariable int customerId, @AuthenticationPrincipal MyUserDetails user) {
        Customer currUser = customerService.findById(user.getCustomer().getId());
        Customer foundCustomer = customerService.findById(customerId);

        AssignFriendFormData formData = new AssignFriendFormData();
        formData.setFriendId(foundCustomer.getId());
        formData.setCustomerId(currUser.getId());
        theModel.addAttribute("formData", formData);
        
        return "customerdetails";
    }
}