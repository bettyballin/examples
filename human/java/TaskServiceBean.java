import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.LocalBean;
import org.jboss.ejb3.annotation.SecurityDomain;
import org.jboss.ejb3.annotation.LocalBinding;

// Sample Roles class
class Roles {
    public static final String ADMIN = "admin";
    public static final String CLERK = "clerk";
    public static final String READ_ONLY = "read_only";
}

// Sample Security class
class Security {
    public static final String DOMAIN = "mySecurityDomain";
}

// Sample Task class
class Task {
    // Task properties and methods here
}

// Sample TaskServiceBeanLocal interface
interface TaskServiceBeanLocal {
    Task save(Task task);
}

@Stateless
@LocalBean
@LocalBinding(jndiBinding = TaskServiceBean.LOOKUP_STRING)
@SecurityDomain(value = Security.DOMAIN)
@DeclareRoles({ Roles.ADMIN, Roles.CLERK, Roles.READ_ONLY })
@RolesAllowed({})
public class TaskServiceBean implements TaskServiceBeanLocal {

    public static final String LOOKUP_STRING = "TaskServiceBean/local";

    @RolesAllowed({ Roles.ADMIN, Roles.CLERK })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Task save(Task task) {
        // Implement the save logic here
        return task; // For example purposes
    }
}