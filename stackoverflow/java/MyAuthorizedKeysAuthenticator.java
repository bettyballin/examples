import org.apache.sshd.server.auth.pubkey.AuthorizedKeysAuthenticator;

public class MyAuthorizedKeysAuthenticator extends AuthorizedKeysAuthenticator {
    public MyAuthorizedKeysAuthenticator(String authorizedKeys) {
        super(authorizedKeys);
    }
}