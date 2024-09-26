import javax.annotation.security.RolesAllowed;
import javax.ejb.Local;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

// Assuming Task and ObjectRepository are defined elsewhere in your project
@Local
public interface TaskServiceBeanLocal extends ObjectRepository<Task> {
    void test();
}

public class TaskServiceBean implements TaskServiceBeanLocal {

    @RolesAllowed({ "ADMIN", "CLERK" })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Task save(Task task) {
        // Implementation details here
        return task;
    }

    @RolesAllowed({ "ADMIN", "CLERK" })
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void test() {
        System.out.println("hello");
    }
}