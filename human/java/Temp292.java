import java.util.ArrayList;
import java.util.List;

// Define the Task class
class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                '}';
    }
}

// Define the ObjectRepository interface
interface ObjectRepository<T> {
    void add(T item);
    List<T> getAll();
}

// Define the TaskServiceBeanLocal interface
interface TaskServiceBeanLocal extends ObjectRepository<Task> {
}

// Implement the TaskServiceBeanLocal interface
class TaskServiceBean implements TaskServiceBeanLocal {
    private List<Task> tasks = new ArrayList<>();

    @Override
    public void add(Task task) {
        tasks.add(task);
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }
}

// Main class
public class Temp292 {
    public static void main(String[] args) {
        TaskServiceBeanLocal taskService = new TaskServiceBean();
        taskService.add(new Task("Task 1"));
        taskService.add(new Task("Task 2"));
        taskService.add(new Task("Task 3"));

        for (Task task : taskService.getAll()) {
            System.out.println(task);
        }
    }
}