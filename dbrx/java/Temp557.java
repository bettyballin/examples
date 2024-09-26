import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class Temp557 {
    public static void main(String[] args) {
        // Application entry point, if needed.
    }

    @RequestMapping(value = "/charity/accounts", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public AccountResponseDto createAccount(HttpServletResponse response, @RequestBody AccountRequestDto requestDTO) {
        // some logics here
        return new AccountResponseDto();
    }

    // Dummy classes for representation
    static class AccountRequestDto {
        // Fields and methods for AccountRequestDto
    }

    static class AccountResponseDto {
        // Fields and methods for AccountResponseDto
    }
}
 won't compile because the dummy classes `AccountRequestDto` and `AccountResponseDto` don't have no-arg constructors.

Here is the corrected code:


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class Temp557 {
    public static void main(String[] args) {
        // Application entry point, if needed.
    }

    @RequestMapping(value = "/charity/accounts", method = RequestMethod.POST)
    @PreAuthorize("permitAll()")
    public AccountResponseDto createAccount(HttpServletResponse response, @RequestBody AccountRequestDto requestDTO) {
        // some logics here
        return new AccountResponseDto();
    }

    // Dummy classes for representation
    static class AccountRequestDto {
        public AccountRequestDto() {
        }
        // Fields and methods for AccountRequestDto
    }

    static class AccountResponseDto {
        public AccountResponseDto() {
        }
        // Fields and methods for AccountResponseDto
    }
}