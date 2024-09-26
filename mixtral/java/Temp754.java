import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class Temp754 {

    public static void main(String[] args) {
        SpringApplication.run(Temp754.class, args);
    }

    @RequestMapping(value = "/charity/accounts", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public AccountResponseDto createAccount(HttpServletResponse response, @RequestBody AccountRequestDto requestDTO) {
        // some logic here
        return new AccountResponseDto();
    }

    static class AccountRequestDto {
        // fields and methods
    }

    static class AccountResponseDto {
        // fields and methods
    }
}