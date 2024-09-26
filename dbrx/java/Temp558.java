import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class Temp558 {

    public static void main(String[] args) {
        // Application entry point
    }

    @RequestMapping(value = "/charity/accounts", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public AccountResponseDto createAccount(HttpServletResponse response, @RequestBody AccountRequestDto requestDTO) {
        // some logics here
        return new AccountResponseDto(); // Dummy return for example purposes
    }

    // Dummy DTO classes for example purposes
    public static class AccountRequestDto {
        public AccountRequestDto() {}
    }

    public static class AccountResponseDto {
        public AccountResponseDto() {}
    }
}