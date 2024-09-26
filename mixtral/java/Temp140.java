class CustomSecurityContext {
    public static Authentication get() {
        // Placeholder for actual authentication retrieval logic
        return new Authentication();
    }
}

class Authentication {
    // Placeholder for actual authentication implementation
}

public class Temp140 {
    public static void main(String[] args) {
        Authentication auth = CustomSecurityContext.get();
        if (auth != null) {
            // Perform your logic here
            System.out.println("Authentication is not null");
        } else {
            System.out.println("Authentication is null");
        }
    }
}