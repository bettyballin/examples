import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.security.access.prepost.PreAuthorize;

@Component("securityUtil")
public class SecurityUtil3 {
    @Autowired
    private Environment environment;

    public String getActiveProfileRole() {
        String activeProfile = environment.getActiveProfiles().length > 0 ? environment.getActiveProfiles()[0] : "default";
        return "SOME_" + activeProfile + "_ROLE";
    }
}

class SomeClass {
    @Autowired
    private SecurityUtil3 securityUtil;

    @PreAuthorize("hasRole(@securityUtil.getActiveProfileRole())")
    public void someMethod() {
        // ...
    }
}