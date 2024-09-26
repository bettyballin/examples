import com.azure.core.management.profile.AzureProfile;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.resourcemanager.AzureResourceManager;
import com.azure.resourcemanager.network.models.NetworkSecurityRule;

public class Temp1366 {
    public static void main(String[] args) {
        // Authenticate and create an Azure resource manager instance
        AzureProfile profile = new AzureProfile(AzureProfile.AZURE);
        AzureResourceManager azureResourceManager = AzureResourceManager
            .authenticate(new DefaultAzureCredentialBuilder().build(), profile)
            .withDefaultSubscription();

        String ruleId = "/subscriptions/your-subscription-id/resourceGroups/your-resource-group/providers/Microsoft.Network/networkSecurityGroups/your-nsg-name/securityRules/your-rule-name";
        
        // Delete the network security rule by ID
        azureResourceManager.networkSecurityRules().deleteById(ruleId);
    }
}