import java.util.ArrayList;
import java.util.List;

class JobService {
    public List<Long> findJobExecutionIdsByUser(String user) {
        // Dummy implementation for demonstration purposes
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        return ids;
    }
}

class JobExecution {
    private Long id;

    public JobExecution(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "JobExecution{id=" + id + "}";
    }
}

class Explorer {
    public JobExecution getJobExecution(Long executionId) {
        // Dummy implementation for demonstration purposes
        return new JobExecution(executionId);
    }
}

public class Temp1292 {
    private static JobService jobService = new JobService();
    private static Explorer explorer = new Explorer();

    public static void main(String[] args) {
        final List<Long> executionIds = jobService.findJobExecutionIdsByUser("user");
        final List<JobExecution> executions = new ArrayList<>();

        for (Long executionId : executionIds) {
            final JobExecution execution = explorer.getJobExecution(executionId);

            if (execution != null) {
                executions.add(execution);
            }
        }

        // Print the executions for demonstration purposes
        for (JobExecution execution : executions) {
            System.out.println(execution);
        }
    }
}