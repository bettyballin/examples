import org.apache.sshd.server.auth.pubkey.PublickeyAuthenticator;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.common.util.security.PublicKeyEntry;
import java.security.PublicKey;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class UserKeySetPublickeyAuthenticator implements PublickeyAuthenticator {
    private final Map<String, Collection<? extends PublicKey>> userToKeySet;

    public UserKeySetPublickeyAuthenticator(Map<String, Collection<? extends PublicKey>> userToKeySet) {
        this.userToKeySet = userToKeySet;
    }

    @Override
    public boolean authenticate(String username, PublicKey key, ServerSession session) {
        Collection<? extends PublicKey> keys = userToKeySet.get(username);
        if (keys == null) {
            return false;
        }
        return keys.stream().anyMatch(publicKey -> publicKey.equals(key));
    }
}