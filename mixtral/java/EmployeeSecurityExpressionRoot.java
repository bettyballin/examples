import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Employee entity
class Employee {
    private Long id;
    private String name;

    // getters and setters
}

// EmployeeRepository interface
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @PreAuthorize("@employeeSecurity.canAccess(authentication, #id)")
    Optional<Employee> findById(@Param("id") long id);
}

// Create a custom security expression root
@Component("employeeSecurity")
public class EmployeeSecurityExpressionRoot {

    public boolean canAccess(Authentication authentication, Long employeeId) {
        // Implement your logic to check if the current user (authentication.getPrincipal())
        // has access rights based on their role and relationship with Employee
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // For example purposes, allow access if the user has a specific role
        return userDetails.getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().equals("ROLE_ADMIN"));
    }
}

// EmployeeService to use repository
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(long id) {
        return employeeRepository.findById(id);
    }
}

// Main application to run the context
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeService employeeService) {
        return args -> {
            // Sample code to use the service
            Optional<Employee> employee = employeeService.getEmployeeById(1L);
            employee.ifPresent(emp -> System.out.println("Employee found: " + emp.getName()));
        };
    }
}