import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service(value = "securityService")
public class SecurityServiceImpl implements SecurityService {

    @Override
    public boolean isCurrentUser(Long id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            CustomUserDetails userDetails = (CustomUserDetails) auth.getPrincipal();
            return userDetails.getId().equals(id);
        }
        return false;
    }
}

interface SecurityService {
    boolean isCurrentUser(Long id);
}

class CustomUserDetails {
    private Long id;

    public CustomUserDetails(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

No changes needed in your code snippet. But ensure you have necessary spring-security dependencies in your project. If not, add these in your `pom.xml`:

xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

Or in your `build.gradle`:

groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-security'
}