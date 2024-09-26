import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@interface Roles {
    String[] value();
}

class Task {
    // Task fields and methods
}

interface TaskService {
    Task save(Task task);
}

class TaskServiceBean implements TaskService {
    @Override
    @Roles({"Clerk", "Admin"})
    public Task save(Task task) {
        // Save logic here
        return task;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            TaskService taskService = new TaskServiceBean();
            Method method = taskService.getClass().getMethod("save", Task.class);
            Roles roles = method.getAnnotation(Roles.class);
            if (roles != null) {
                List<String> requiredRoles = Arrays.asList(roles.value());
                System.out.println("Method: " + method);
                System.out.println("Interface: Local");
                System.out.println("Required Roles: " + requiredRoles);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}