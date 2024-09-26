import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

public class Temp1091 {
    public static void main(String[] args) {
        try {
            String pubKey = Files.readString(Paths.get("path/to/client-publickey"));
            PublicKey publicKey = KeyUtils.decodePublicKey(Base64.getDecoder().decode(pubKey));

            List<UserAuth> userAuths = new ArrayList<>();
            userAuths.add(new UserAuthPublicKey.Builder()
                    .username("client")
                    .key(publicKey)
                    .build());

            SshServer sshServer = new SshServer();
            sshServer.setUserAuthFactories(Collections.singletonList(
                    (authFact) -> new SimpleGeneratorHostConfigurator<>(
                            authFact::createUserAuth,
                            userAuths
                    )));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class KeyUtils {
    public static PublicKey decodePublicKey(byte[] keyBytes) {
        // Implement the method to decode the public key
        return null;
    }
}

class UserAuth {}

class UserAuthPublicKey extends UserAuth {
    public static class Builder {
        public Builder username(String username) {
            // Implement the method
            return this;
        }

        public Builder key(PublicKey key) {
            // Implement the method
            return this;
        }

        public UserAuthPublicKey build() {
            // Implement the method
            return new UserAuthPublicKey();
        }
    }
}

class SshServer {
    public void setUserAuthFactories(List<?> factories) {
        // Implement the method
    }
}

class SimpleGeneratorHostConfigurator<T> {
    public SimpleGeneratorHostConfigurator(Object createUserAuth, List<T> userAuths) {
        // Implement the constructor
    }
}