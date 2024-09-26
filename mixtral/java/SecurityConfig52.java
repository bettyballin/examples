import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.security.access.prepost.PreAuthorize;

public class SecurityConfig {

  private String readRole;

  public SecurityConfig(String readRole) {
      this.readRole = readRole;
  }

  public String getReadRole() {
      return readRole;
  }
}

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAuthority(@securityConfig.readRole)")
public @interface SecuredByRole {
}

// Example usage
@SecuredByRole
public class ExampleService {

    public void exampleMethod() {
        System.out.println("Executing example method...");
    }

    public static void main(String[] args) {
        SecurityConfig securityConfig = new SecurityConfig("ROLE_USER");
        ExampleService service = new ExampleService();
        service.exampleMethod();
    }
}