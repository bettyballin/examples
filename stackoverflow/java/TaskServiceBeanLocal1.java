import javax.ejb.Local;

@Local
public interface TaskServiceBeanLocal1 extends ObjectRepository<Task> {
    Task save(Task object);
    void test();
}