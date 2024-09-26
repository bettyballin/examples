import java.security.Security;

public class ExecutorServiceSecurityInterceptor implements SecurityInterceptor {
    @Override
    public void beforeOperation(Operation op) {
        if (op instanceof DistributedExecutorOperation && shouldBlockExecution(op)) {
            throw new SecurityException("Execution of tasks is not allowed on this node");
        }
    }

    private boolean shouldBlockExecution(Operation op) {
        // Add your logic here to determine if the execution should be blocked
        return true;
    }

    @Override
    public void afterOperation(Operation op) {
        // No-op
    }
}

interface SecurityInterceptor {
    void beforeOperation(Operation op);
    void afterOperation(Operation op);
}

interface Operation {
    // Operation methods
}

class DistributedExecutorOperation implements Operation {
    // Implementation specific to DistributedExecutorOperation
}