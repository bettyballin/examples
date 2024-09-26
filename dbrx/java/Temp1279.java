import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sts.StsClient;
import software.amazon.awssdk.services.sts.model.AssumeRoleRequest;
import software.amazon.awssdk.services.sts.model.AssumeRoleResponse;

public class Temp1279 {
    public static void main(String[] args) {

        // Replace these with your actual AWS access key and secret key
        String accessKey = "your-access-key";
        String secretKey = "your-secret-key";

        AwsBasicCredentials awsCredentials = AwsBasicCredentials.create(accessKey, secretKey);

        StsClient stsClient = StsClient.builder()
                .credentialsProvider(StaticCredentialsProvider.create(awsCredentials))
                .region(Region.US_EAST_1)
                .build();

        AssumeRoleRequest assumeRoleRequestRead = AssumeRoleRequest.builder()
                .roleArn("<role-1-arn>")
                .durationSeconds(7200)
                .roleSessionName("session-role-read-" + System.currentTimeMillis())
                .build();

        AssumeRoleResponse assumeRoleResponseRead = stsClient.assumeRole(assumeRoleRequestRead);

        // Output the assumed role credentials
        System.out.println("Assumed Role ARN: " + assumeRoleResponseRead.assumedRoleUser().arn());
        System.out.println("Access Key ID: " + assumeRoleResponseRead.credentials().accessKeyId());
        System.out.println("Secret Access Key: " + assumeRoleResponseRead.credentials().secretAccessKey());
        System.out.println("Session Token: " + assumeRoleResponseRead.credentials().sessionToken());
    }
}