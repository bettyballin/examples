import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RestController
public class Temp273 {

    @PreAuthorize("hasRole('ROLE_FORUM_MANAGER') && @roomPermissionEvaluator.hasRoomManagementAccess(authentication, #room)")
    public void manageRoom(@PathVariable Room room) {
        // ...
    }

    public static void main(String[] args) {
        // Spring Boot application entry point
    }

    // Security configuration class
    public static class SecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers("/rooms/**").access("@roomPermissionEvaluator.hasRoomManagementAccess(authentication, #request)")
                    .anyRequest().authenticated();
        }
    }
}

// Dummy Room class for demonstration purposes
class Room {
    // Room properties and methods
}

// Dummy RoomPermissionEvaluator class for demonstration purposes
class RoomPermissionEvaluator {
    public boolean hasRoomManagementAccess(Object authentication, Object room) {
        // Logic to check if the user has access
        return true;
    }
}