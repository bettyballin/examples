import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Temp1882 {

    private final TaskRepository taskRepository;

    public Temp1882(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public static void main(String[] args) {
        // Spring application context initialization would be here in a real application
    }

    @Transactional
    public void createTask(CreateTaskDto task) {
        // convert DTO to Entity
        TaskEntity entity = new TaskEntity();
        entity.setName(task.getName());
        entity.setDescription(task.getDescription());

        this.taskRepository.save(entity);
    }
}

interface TaskRepository {
    void save(TaskEntity entity);
}

class CreateTaskDto {
    private String name;
    private String description;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class TaskEntity {
    private String name;
    private String description;

    // getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}