import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Local
public interface TaskServiceBean1Local {
    @RolesAllowed({Roles.ADMIN, Roles.CLERK})
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    Task save(Task task);

    void test();
}

public class TaskServiceBean1 implements TaskServiceBean1Local {

    @RolesAllowed({Roles.ADMIN, Roles.CLERK})
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Task save(Task task) {
        // Implementation goes here
        return null;
    }

    @RolesAllowed({Roles.ADMIN, Roles.CLERK})
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void test() {
        System.out.println("hello");
    }
}

class Task {
    // Task implementation
}

class Roles {
    public static final String ADMIN = "ADMIN";
    public static final String CLERK = "CLERK";
}