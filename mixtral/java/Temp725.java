import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.DefaultRedirectStrategy;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class Temp725 {

    @Autowired
    private RedirectStrategy redirectStrategy;

    public Temp725() {
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    @GetMapping("/externalAuth")
    public String externalAuth(HttpServletResponse response) {
        boolean someCondition = true; // Placeholder for the actual condition
        String someExternalUrl = "http://www.example.com"; // Placeholder for the actual URL

        if (someCondition) {
            try {
                this.redirectStrategy.sendRedirect(response, someExternalUrl);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return "redirect:/";
        }
    }

    public static void main(String[] args) {
        // Application entry point if needed
    }
}