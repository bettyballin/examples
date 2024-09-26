import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping(value="/charity")
public class CharityController {

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public AccountResponseDto getAccount(HttpServletResponse response){
        // Implement your logic here and return an instance of AccountResponseDto
        return new AccountResponseDto();
    }
}

class AccountResponseDto {
    // Define fields, constructors, getters, and setters here
}