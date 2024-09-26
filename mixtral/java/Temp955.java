import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateAclsResult;
import org.apache.kafka.common.acl.AccessControlEntry;
import org.apache.kafka.common.acl.AclBinding;
import org.apache.kafka.common.acl.AclOperation;
import org.apache.kafka.common.acl.AclPermissionType;
import org.apache.kafka.common.resource.ResourcePattern;
import org.apache.kafka.common.resource.ResourcePatternFilter;
import org.apache.kafka.common.resource.ResourceType;

import java.util.Properties;

public class Temp955 {

    public static void main(String[] args) {

        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        AdminClient admin = AdminClient.create(props);

        ResourcePattern resource = new ResourcePattern(ResourceType.ANY, "*", ResourcePatternFilter.ANY);
        AccessControlEntry entry = new AccessControlEntry("User:*", "*", AclOperation.ALL, AclPermissionType.ALLOW);

        List<AclBinding> aclsToAdd = Arrays.asList(
                new AclBinding(resource, entry)
        );

        try {
            CreateAclsResult result = admin.createAcls(aclsToAdd);
            result.all().get();
            System.out.println("ACLs successfully created.");
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            admin.close();
        }
    }
}