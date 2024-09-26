import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.network.NetworkSecurityGroup;
import com.microsoft.azure.management.network.SecurityRule;
import com.microsoft.rest.LogLevel;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.network.implementation.NetworkManager;
import rx.Observable;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class Temp2050 {
    public static void main(String[] args) {
        try {
            // Authenticate with Azure
            ApplicationTokenCredentials credentials = new ApplicationTokenCredentials(
                "client-id", "tenant-id", "client-secret", AzureEnvironment.AZURE);
            Azure azure = Azure.configure()
                    .withLogLevel(LogLevel.BASIC)
                    .authenticate(credentials)
                    .withDefaultSubscription();

            String resourceGroupName = "your-resource-group";
            String nsgName = "your-nsg-name";

            // Get the network security group
            NetworkSecurityGroup nsg = azure.networkSecurityGroups().getByResourceGroup(resourceGroupName, nsgName);

            // List security rules asynchronously
            List<SecurityRule> list = nsg.securityRules().list();

            // Iterate over the collection and delete specific rule
            for (Iterator<SecurityRule> iterator = list.iterator(); iterator.hasNext(); ) {
                SecurityRule securityRule = iterator.next();
                if ("myRule".equals(securityRule.name())) {
                    azure.networkSecurityGroups()
                        .securityRules()
                        .deleteByNetworkSecurityGroup(resourceGroupName, nsgName, "myRule");

                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}