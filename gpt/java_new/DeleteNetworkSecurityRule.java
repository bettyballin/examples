import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.network.NetworkSecurityGroup;
import com.microsoft.azure.management.resources.fluentcore.arm.ResourceId;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.rest.LogLevel;

import java.io.File;
import java.io.IOException;

public class DeleteNetworkSecurityRule {

    public static void main(String[] args) {
        final String clientId = "your-client-id";
        final String tenantId = "your-tenant-id";
        final String secret = "your-secret";
        final String subscriptionId = "your-subscription-id";
        final String resourceGroupName = "your-resource-group-name";
        final String nsgName = "your-nsg-name";
        final String ruleName = "your-rule-name";

        try {
            ApplicationTokenCredentials credentials = new ApplicationTokenCredentials(clientId, tenantId, secret, null);
            Azure azure = Azure.configure()
                    .withLogLevel(LogLevel.BASIC)
                    .authenticate(credentials)
                    .withSubscription(subscriptionId);

            NetworkSecurityGroup nsg = azure.networkSecurityGroups().getByResourceGroup(resourceGroupName, nsgName);
            nsg.update().withoutRule(ruleName).apply();
            
            System.out.println("Network security rule deleted: " + ruleName);
        } catch (Exception e) {
            System.err.println("Exception occurred while deleting rule: " + e.getMessage());
            e.printStackTrace();
        }
    }
}