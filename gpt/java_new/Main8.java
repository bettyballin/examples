import java.net.Authenticator;

public class Main8 {
    public static void main(String[] args) {
        // Set to your custom authenticator
        Authenticator myAuthenticator = new MyAuthenticator();
        Authenticator.setDefault(myAuthenticator);

        // ... your code to access the protected URL ...

        // Reset the Authenticator to null, meaning no authenticator is set
        Authenticator.setDefault(null);
    }

    private static class MyAuthenticator extends Authenticator {
        // Implement the required methods for your custom authenticator
    }
}