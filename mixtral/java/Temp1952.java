import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Temp1952 {

    @RequestMapping("/test")
    public ModelAndView handleRequest(HttpServletResponse response) {
        // Option 1: Using ModelAndView
        return new ModelAndView("redirect:/welcome");

        // Option 2: Using HttpServletResponse
        // response.setHeader("Location", "/welcome");
        // response.setStatus(302);
        // return null;
    }

    public static void main(String[] args) {
        System.out.println("Temp1952 is running. Access /test endpoint to test redirection.");
    }
}