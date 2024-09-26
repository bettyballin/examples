Here is the corrected code:


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public SecurityServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean hasAccess(Long empId, Authentication authentication) {
        String username = authentication.getName();
        User user = (User) authentication.getPrincipal();

        // Check if the requested resource belongs to this authenticated user.
        return employeeRepository.findById(empId).map(employee ->
            employee.getUsername().equals(username)
        ).orElse(false);
    }
}

// Assuming the following interfaces and classes are defined somewhere in your project

interface SecurityService {
    boolean hasAccess(Long empId, Authentication authentication);
}

interface EmployeeRepository {
    Optional<Employee> findById(Long empId);
}

class Employee {
    private Long id;
    private String username;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}