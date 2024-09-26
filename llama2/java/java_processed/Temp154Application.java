import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@SpringBootApplication
public class Temp154Application {

    public static void main(String[] args) {
        SpringApplication.run(Temp154Application.class, args);
    }
}

@Component
class UuidGenerator {
    public UUID generate() {
        return UUID.randomUUID();
    }
}

@Controller
class Temp154 {

    private final UuidGenerator uuidGenerator;

    @Autowired
    public Temp154(UuidGenerator uuidGenerator) {
        this.uuidGenerator = uuidGenerator;
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(@RequestParam("email") String email) {
        // Generate a new UUID for the password reset request
        UUID resetId = uuidGenerator.generate();

        // Store the reset ID in your database or session
        // ...

        // Create a dynamic link using the reset ID
        String resetLink = "http://example.com/reset-password/" + resetId;

        // Send the dynamic link to the user's email address
        // ...

        return "Password reset link sent to your email";
    }
}