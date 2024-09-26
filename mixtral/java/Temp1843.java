import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;

public class UserResolver {

    @Override
    protected Object resolveName(String name, MethodParameter parameter, NativeWebRequest request) throws Exception {
        User currentUser = getCurrentUser();

        if (currentUser == null || !isAuthorized(parameter))
            throw new UserUnauthorizedException("The user is not authorized");

        return currentUser.getId();
    }

    private boolean isAuthorized(MethodParameter parameter) {
        CurrentUserId annotation = parameter.getParameterAnnotation(CurrentUserId.class);

        if (annotation == null || !annotation.required())
            return true;

        // Add your authorization logic here

        return false;
    }

    private User getCurrentUser() {
        // Mocking current user retrieval, replace with actual logic
        return new User(1, "testUser");
    }

    public static void main(String[] args) {
        try {
            UserResolver resolver = new UserResolver();
            MethodParameter parameter = new MethodParameter(
                    UserResolver.class.getDeclaredMethod("resolveName", String.class, MethodParameter.class, NativeWebRequest.class), 1);
            NativeWebRequest request = new MockNativeWebRequest();
            System.out.println(resolver.resolveName("name", parameter, request));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Mock classes to make the code executable
    static class User {
        private final int id;
        private final String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }
    }

    static class UserUnauthorizedException extends Exception {
        public UserUnauthorizedException(String message) {
            super(message);
        }
    }

    @interface CurrentUserId {
        boolean required() default true;
    }

    static class MockNativeWebRequest implements NativeWebRequest {
        // Implement required methods for the NativeWebRequest interface
    }
}