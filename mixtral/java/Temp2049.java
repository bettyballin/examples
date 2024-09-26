import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.network.models.NetworkSecurityGroup;
import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class Temp2049 {
    public static void main(String[] args) {
        // Define the resource group and network security group name
        String resourceGroupName = "myResourceGroup";
        String nsgName = "myNetworkSecurityGroup";

        // Authenticate using DefaultAzureCredential
        AzureProfile profile = new AzureProfile(AzureProfile.AzureEnvironment.AZURE);
        AzureResourceManager manager = AzureResourceManager
            .authenticate(new DefaultAzureCredentialBuilder().build(), profile)
            .withDefaultSubscription();

        // Get a reference to the Network Security Group
        NetworkSecurityGroup nsg = manager.networkSecurityGroups().getByResourceGroup(resourceGroupName, nsgName);

        if (nsg != null) {
            // Delete the Network Security Group
            manager.networkSecurityGroups().deleteByResourceGroup(resourceGroupName, nsgName);
            System.out.println("Deleted Network Security Group: " + nsgName);
        } else {
            System.out.println("Network Security Group not found: " + nsgName);
        }
    }
}