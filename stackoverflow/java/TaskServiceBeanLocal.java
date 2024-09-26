import javax.ejb.Local;
import some.package.ObjectRepository; // Replace with the actual package name where ObjectRepository is located
import your.domain.task.Task; // Replace with the actual package and class Task

@Local
public interface TaskServiceBeanLocal extends ObjectRepository<Task> {
}