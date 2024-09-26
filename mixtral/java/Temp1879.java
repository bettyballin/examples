import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

public class Temp1879 {
    public static void main(String[] args) {
        // Main method logic if needed
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().authenticationEntryPoint((request, response, authException) -> 
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED));
    }

    @Controller
    public static class ErrorController {
        @RequestMapping("/error/401")
        public String unauthorized() {
            return "views/errors/401";
        }
    }
}