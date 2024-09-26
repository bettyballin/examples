import com.auth0.client.auth.AuthAPI;
import com.auth0.client.mgmt.ManagementAPI;
import com.auth0.json.mgmt.users.User;
import com.auth0.net.Request;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AuthAPI auth = new AuthAPI("your-domain", "your-client-id", "your-client-secret");
        ManagementAPI mgmt = new ManagementAPI(auth);
        String userId = "user_id_here";
        Map<String, Object> metadataUpdates = new HashMap<>();
        Map<String, String> appMetadata = new HashMap<>();
        appMetadata.put("key1", "value1");
        metadataUpdates.put("app_metadata", appMetadata);
        User user = new User();
        user.setAppMetadata(metadataUpdates);
        Request<User> request = mgmt.users().update(userId, user);
        try {
            User updatedUser = request.execute();
            System.out.println("User updated successfully: " + updatedUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}