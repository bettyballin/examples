import java.util.Map;

class UnauthorizedException extends Exception {
    public UnauthorizedException(String message) {
        super(message);
    }
}

class Auth0UserServiceImpl {
    public void updateAppMetadata(String userId, Map<String, Object> metadata) throws UnauthorizedException {
        // Simulate updating app metadata
        System.out.println("Updating app metadata for user " + userId);
    }
}

public class CustomUserService extends Auth0UserServiceImpl {
    @Override
    public void updateAppMetadata(String userId, Map<String, Object> metadata) throws UnauthorizedException {
        super.updateAppMetadata(userId, metadata);
    }

    public static void main(String[] args) {
        CustomUserService service = new CustomUserService();
        try {
            service.updateAppMetadata("user123", Map.of("key1", "value1"));
        } catch (UnauthorizedException e) {
            e.printStackTrace();
        }
    }
}