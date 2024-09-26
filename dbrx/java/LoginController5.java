import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login/company")
    public String companyLogin(@RequestParam("companyName") String companyName, 
                               @RequestParam("password") String password, 
                               Model model) {
        CompanyDetails company = fetchCompanyDetails(companyName); // fetch the details from your service

        if (company == null || !password.equals(company.getPassword())) { // assuming you have a getPassword() method in your entity
            model.addAttribute("error", "Invalid credentials");
            return "/login/company";
        }

        UsernamePasswordAuthenticationToken authRequest =
                new UsernamePasswordAuthenticationToken(companyName, password);

        Authentication authentication = authenticationManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // redirect to the desired page
        return "redirect:/desiredPage";
    }

    private CompanyDetails fetchCompanyDetails(String companyName) {
        // Implement this method to fetch company details from your service
        return new CompanyDetails();
    }
    
    static class CompanyDetails {
        // Dummy CompanyDetails class, replace with your actual implementation
        private String password;

        public CompanyDetails() {
            this.password = "";
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}