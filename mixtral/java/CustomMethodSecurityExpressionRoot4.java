import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.ObjectUtils;

public class CustomMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {
    private Authentication authentication;
    private Object filterObject;
    private Object returnObject;
    private final UserDetailsService userDetailsService;

    public CustomMethodSecurityExpressionRoot(Authentication authentication, UserDetailsService userDetailsService) {
        super(authentication);
        this.authentication = authentication;
        this.userDetailsService = userDetailsService;
    }

    public boolean isAllowedToViewEmployee(Long empId) {
        if (authentication == null) 
            return false;

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        boolean isUser = authentication.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .anyMatch(role -> role.equalsIgnoreCase("User"));

        if (!isUser) 
            return false;

        CustomEmployeeDetails currentEmp = (CustomEmployeeDetails) userDetailsService.loadUserByUsername(authentication.getName());

        // Allow access if the employee IDs match
        return empId != null && ObjectUtils.nullSafeEquals(empId, currentEmp.getId());
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return this.filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return this.returnObject;
    }

    @Override
    public Object getThis() {
        return this;
    }
}

class CustomEmployeeDetails extends org.springframework.security.core.userdetails.User {
    private Long id;

    public CustomEmployeeDetails(String username, String password, Long id) {
        super(username, password, new ArrayList<>());
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}