import java.util.ArrayList;
import java.util.List;

class SystemUser {
    // Assuming SystemUser class has necessary properties and methods
}

class Task {
    // Assuming Task class has necessary properties and methods
}

class Guard {
    public static void allowFor(SystemUser user) {
        // Assuming some logic to allow for a SystemUser
    }
}

public class TaskList {

    private SystemUser owner;
    private List<Task> tasks = new ArrayList<>();

    public TaskList(SystemUser owner) {
        this.owner = owner;
    }

    public void Add(Task task) {
        Guard.allowFor(owner); 
        tasks.add(task);
    }

    public static void main(String[] args) {
        // Example usage
        SystemUser user = new SystemUser();
        TaskList taskList = new TaskList(user);
        Task task = new Task();
        taskList.Add(task);
    }
}