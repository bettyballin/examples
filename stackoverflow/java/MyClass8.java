import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;

public class MyClass8 {

    @PreAuthorize("hasRole('SOME_' + T(org.springframework.util.StringUtils).arrayToCommaDelimitedString(environment.getActiveProfiles()).toUpperCase() + '_ROLE')")
    public void method(@Value("#{ T(org.springframework.util.StringUtils).arrayToCommaDelimitedString(environment.getActiveProfiles()).toUpperCase() }") String profile) {
        // method implementation
    }
}