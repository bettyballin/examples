import org.apache.sshd.server.config.keys.AuthorizedKeysAuthenticator;

public class Temp1913 {
    public static void main(String[] args) {
        // Example of using AuthorizedKeysAuthenticator
        AuthorizedKeysAuthenticator authenticator = new AuthorizedKeysAuthenticator("path/to/authorized_keys");
        System.out.println("Authenticator created: " + authenticator);
    }
}