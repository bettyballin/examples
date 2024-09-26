import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class NodeCreationTask {

    private static final int MAX_NODE_CREATION_DELAY_IN_SECONDS = 10;

    private final ScheduledExecutorService nodeCreationExecutor = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        NodeCreationTask nodeCreationTask = new NodeCreationTask();
        nodeCreationTask.scheduleNodeCreation("filename", "type", "parentNode", "label", "kinematic");
    }

    public void scheduleNodeCreation(String filename, String type, String parentNode, String label, String kinematic) {
        // Get the SecurityContext hold by the main thread
        final SecurityContext securityContext = SecurityContextHolder.getContext();

        final ScheduledFuture<NodeRef> scheduledFuture = nodeCreationExecutor.schedule(new Callable<NodeRef>() {

            @Override
            public NodeRef call() throws Exception {

                // Inject the securityContext
                SecurityContextHolder.setContext(securityContext);

                // HERE I MAKE THE EFFECTIVE NODE CREATION
                NodeRef noderef = createNodeRef(filename, type, parentNode, label, kinematic);

                // Cleaning...the thread may be recycled
                SecurityContextHolder.setContext(null);

                return noderef;

            }
        }, MAX_NODE_CREATION_DELAY_IN_SECONDS, TimeUnit.SECONDS);
    }

    // Dummy method to simulate node creation
    private NodeRef createNodeRef(String filename, String type, String parentNode, String label, String kinematic) {
        // Simulate node creation logic here
        return new NodeRef(filename, type, parentNode, label, kinematic);
    }

    // Dummy NodeRef class to simulate the return type
    static class NodeRef {
        private String filename;
        private String type;
        private String parentNode;
        private String label;
        private String kinematic;

        public NodeRef(String filename, String type, String parentNode, String label, String kinematic) {
            this.filename = filename;
            this.type = type;
            this.parentNode = parentNode;
            this.label = label;
            this.kinematic = kinematic;
        }

        @Override
        public String toString() {
            return "NodeRef{" +
                    "filename='" + filename + '\'' +
                    ", type='" + type + '\'' +
                    ", parentNode='" + parentNode + '\'' +
                    ", label='" + label + '\'' +
                    ", kinematic='" + kinematic + '\'' +
                    '}';
        }
    }
}