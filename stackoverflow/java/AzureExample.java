import com.microsoft.azure.AzureEnvironment;
import com.microsoft.azure.credentials.ApplicationTokenCredentials;
import com.microsoft.azure.management.Azure;
import com.microsoft.azure.management.network.NetworkSecurityGroup;
import com.microsoft.rest.LogLevel;

public class AzureExample {
    public static void main(String[] args) {
        String clientId = "your sp appId";
        String secret = "your sp password";
        String domain = "your tenant domain";
        ApplicationTokenCredentials credentials = new ApplicationTokenCredentials(clientId, domain, secret,
                AzureEnvironment.AZURE);
        Azure azure = Azure.configure().withLogLevel(LogLevel.BASIC).authenticate(credentials)
                .withDefaultSubscription();

        NetworkSecurityGroup group = azure.networkSecurityGroups().getById(
                "your nsg resource id");

        for (String i : group.securityRules().keySet()) {
            System.out.println(i);
        }

        group.update().withoutSecurityRule("ruleName").apply();
        group = azure.networkSecurityGroups().getById(
                "/subscriptions/e5b0fcfa-e859-43f3-8d84-5e5fe29f4c68/resourceGroups/testgroup/providers/Microsoft.Network/networkSecurityGroups/test0123");
        System.out.println(group.name());
        for (String i : group.securityRules().keySet()) {
            System.out.println(i);
        }
    }
}