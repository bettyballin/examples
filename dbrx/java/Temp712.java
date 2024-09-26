import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.AclBinding;
import org.apache.kafka.clients.admin.CreateAclsResult;
import org.apache.kafka.common.acl.AccessControlEntry;
import org.apache.kafka.common.acl.AclOperation;
import org.apache.kafka.common.acl.AclPermissionType;
import org.apache.kafka.common.resource.PatternType;
import org.apache.kafka.common.resource.ResourcePattern;
import org.apache.kafka.common.resource.ResourceType;

import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Temp712 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Kafka properties
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        // Create Kafka admin client
        try (Admin admin = Admin.create(props)) {
            // Define the resource pattern
            ResourcePattern resourcePattern = new ResourcePattern(ResourceType.TOPIC, "marchTesting", PatternType.LITERAL);

            // Define the access control entry
            AccessControlEntry entry = new AccessControlEntry("user:ctadmin", "*", AclOperation.ALL, AclPermissionType.ALLOW);

            // Define the ACL binding
            AclBinding aclBinding = new AclBinding(resourcePattern, entry);

            // Create ACLs
            List<AclBinding> aclsToAdd = Collections.singletonList(aclBinding);
            CreateAclsResult result = admin.createAcls(aclsToAdd);

            // Wait for the operation to complete
            result.all().get(10, TimeUnit.SECONDS);
        }
    }
}