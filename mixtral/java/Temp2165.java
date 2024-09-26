import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class Main {
    public static void main(String[] args) {
        Authentication auth = Mockito.mock(Authentication.class);
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);

        when(securityContext.getAuthentication()).thenReturn(auth);

        // Set the Security Context in Spring
        SecurityContextHolder.setContext(securityContext);

        EmployeeDetails details = new EmployeeDetails();
        details.setEmployeeId("123");

        when(auth.getPrincipal()).thenReturn(details);

        // Verify the setup
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        EmployeeDetails principal = (EmployeeDetails) authentication.getPrincipal();
        System.out.println("Employee ID: " + principal.getEmployeeId());
    }
}

class EmployeeDetails {
    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}