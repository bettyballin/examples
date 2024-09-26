import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.regions.Regions;

public class AwsStsClientExample {
    public static void main(String[] args) {
        // Initialize the STS client
        AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder.standard()
                .withRegion(Regions.DEFAULT_REGION).build();

        // Assume the read-only role (Role ARN and Role Session Name are required)
        AssumeRoleRequest readOnlyAssumeRoleRequest = new AssumeRoleRequest()
                .withRoleArn("arn:aws:iam::ACCOUNT_ID:role/ROLE_NAME")
                .withRoleSessionName("ReadOnlySession");

        // Call assumeRole method (Not shown here as the request is incomplete and for demonstration purposes)
        // stsClient.assumeRole(readOnlyAssumeRoleRequest);
    }
}