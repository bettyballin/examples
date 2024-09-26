import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@LocalBean
@DeclareRoles({ Roles.ADMIN, Roles.CLERK, Roles.READ_ONLY })
@RolesAllowed({})
public class TaskServiceBean implements TaskServiceBeanLocal {

    public static final String LOOKUP_STRING = "TaskServiceBean/local";

    @RolesAllowed({ Roles.ADMIN, Roles.CLERK })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Task save(Task task) {
        // ...
        return null;
    }
}

interface TaskServiceBeanLocal {
    Task save(Task task);
}

class Task {
}

class Roles {
    static final String ADMIN = "ADMIN";
    static final String CLERK = "CLERK";
    static final String READ_ONLY = "READ_ONLY";
}