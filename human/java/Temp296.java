import java.util.List;

public class Temp296 {
    public static void main(String[] args) {
        // Example usage of TaskServiceBeanLocal
        TaskServiceBeanLocal taskService = new TaskServiceBean();
        Task task = new Task("Example Task");
        taskService.save(task);
        taskService.test();
    }
}

interface TaskServiceBeanLocal {
    Task save(Task object);
    void test();
}

class TaskServiceBean implements TaskServiceBeanLocal {
    @Override
    public Task save(Task object) {
        System.out.println("Task saved: " + object.getName());
        return object;
    }

    @Override
    public void test() {
        System.out.println("Test method called");
    }
}

class Task {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}