import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Component;

@Component("appVariablesHolder")
class AppVariablesHolder {

    @Value("${role.rolename}") 
    private String someRole;

    public String getSomeRole() {
        return this.someRole;
    }
}

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@ComponentScan(basePackages = "your.package.name") // change this to your package name
class SecurityConfig {}

public class YourService {

    private final AppVariablesHolder appVariablesHolder;

    public YourService(AppVariablesHolder appVariablesHolder) {
        this.appVariablesHolder = appVariablesHolder;
    }

    @PreAuthorize("hasRole(@appVariablesHolder.getSomeRole())")
    public void method() {
        // method implementation
    }
}