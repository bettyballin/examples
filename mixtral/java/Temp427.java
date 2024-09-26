import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class Temp427 {

    public static void main(String[] args) {
        // Spring Boot application entry point
        org.springframework.boot.SpringApplication.run(Temp427.class, args);
    }

    @GetMapping("/getAuthorization")
    public String getAuthorization() {
        List<String> roles = SecurityContextHolder
                .getContext().getAuthentication().getAuthorities().stream()
                .map(GrantedAuthority::getAuthority).collect(Collectors.toList());

        if (!roles.isEmpty())
            return roles.get(0);

        throw new RuntimeException("User has no role");
    }
}