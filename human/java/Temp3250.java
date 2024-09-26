import software.amazon.awssdk.auth.credentials.AwsSessionCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.dynamodb.model.ResourceNotFoundException;

import java.util.HashMap;

public class Temp3250 {
    public static void main(String[] args) {
        AwsSessionCredentials credentials = AwsSessionCredentials.create(
                "the_returned_access_key_id",
                "the_returned_secret_key_id",
                "the_returned_session_token"
        );

        DynamoDbClient ddb = DynamoDbClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .build();

        HashMap<String, AttributeValue> itemValues = new HashMap<>();

        itemValues.put("serial_number", AttributeValue.builder().s("123456789").build());
        itemValues.put("timestamp", AttributeValue.builder().s("2017-11-20T06:00:00.000Z").build());
        itemValues.put("current_temp", AttributeValue.builder().n("65").build());
        itemValues.put("target_temp", AttributeValue.builder().n("70").build());
        itemValues.put("humidity", AttributeValue.builder().n("45").build());

        PutItemRequest request = PutItemRequest.builder()
                .tableName("MyHomeThermostat")
                .item(itemValues)
                .build();

        try {
            ddb.putItem(request);
        } catch (ResourceNotFoundException e) {
            System.err.println("Table not found: " + e.getMessage());
        } catch (DynamoDbException e) {
            System.err.println("DynamoDB error: " + e.getMessage());
        }
    }
}