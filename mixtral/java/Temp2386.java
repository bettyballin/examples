import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PasswordEncoder {
    public String encode(String password) {
        return password; // This should be the actual implementation
    }
}

class UserCreateDto {
    private String username;
    private String firstname;
    private String email;
    private String secondaryEmail;
    private String password;
    private String role;
    private String encodedPassword;

    public UserCreateDto(String username, String firstname, String email, String secondaryEmail, String password, String role) {
        this.username = username;
        this.firstname = firstname;
        this.email = email;
        this.secondaryEmail = secondaryEmail;
        this.password = password;
        this.role = role;
    }

    public void setEncodedPassword(String encodedPassword) {
        this.encodedPassword = encodedPassword;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }
}

@ExtendWith(MockitoExtension.class)
public class Temp2386 {

    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoding() {
        MockitoAnnotations.openMocks(this);

        when(passwordEncoder.encode("123456")).thenReturn("encodedPassword");

        UserCreateDto userCreatedDto = new UserCreateDto("user", "test", "user@gmail.com",
                "user@gmail.com", "123456", "basic");

        userCreatedDto.setEncodedPassword(passwordEncoder.encode("123456"));

        assertEquals("encodedPassword", userCreatedDto.getEncodedPassword());
    }

    public static void main(String[] args) {
        Temp2386 temp2386 = new Temp2386();
        temp2386.testPasswordEncoding();
    }
}