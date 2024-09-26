import java.security.PublicKey;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

// Mocking the required interfaces and classes for the code to be executable

interface PublickeyAuthenticator {
    boolean authenticate(String username, PublicKey key, ServerSession session);
}

class ServerSession {
    // Placeholder for the ServerSession class
}

class KeyUtils {
    // Mocked method for KeyUtils
    public static PublicKey findMatchingKey(PublicKey key, Collection<? extends PublicKey> keys) {
        for (PublicKey k : keys) {
            if (k.equals(key)) {
                return k;
            }
        }
        return null;
    }
}

public class UserKeySetPublickeyAuthenticator implements PublickeyAuthenticator {
    private final Map<String, Collection<? extends PublicKey>> userToKeySet;

    public UserKeySetPublickeyAuthenticator(Map<String, Collection<? extends PublicKey>> userToKeySet) {
        this.userToKeySet = userToKeySet;
    }

    @Override
    public boolean authenticate(String username, PublicKey key, ServerSession session) {
        return KeyUtils.findMatchingKey(key, userToKeySet.getOrDefault(username, Collections.emptyList())) != null;
    }

    public static void main(String[] args) {
        // Placeholder for testing the class
    }
}