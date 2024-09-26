import java.io.File;
import java.io.IOException;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.sshd.common.config.keys.AuthorizedKeyEntry;
import org.apache.sshd.common.config.keys.loader.pem.PEMResourceParserUtils;
import org.apache.sshd.common.config.keys.loader.pem.PEMResourceParserUtils.PEMResourceParser;
import org.apache.sshd.common.util.security.SecurityUtils;

public class Temp1917 {
    public static void main(String[] args) {
        Map<String, List<PublicKey>> userKeysMap = new HashMap<>();
        List<String> users = Arrays.asList("Jim", "Sally", "Bob");
        for (String user : users) {
            List<PublicKey> usersKeys = new ArrayList<>();
            try {
                for (AuthorizedKeyEntry ake : AuthorizedKeyEntry.readAuthorizedKeys(new File(user + "_authorized_keys"))) {
                    PublicKey publicKey = ake.resolvePublicKey(PublicKeyEntryResolver.IGNORING);
                    if (publicKey != null) {
                        usersKeys.add(publicKey);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            userKeysMap.put(user, usersKeys);
        }
    }
}

class PublicKeyEntryResolver {
    public static final PEMResourceParser IGNORING = new PEMResourceParser() {
        @Override
        public boolean isValid(String resourceKeyFormat) {
            return true;
        }

        @Override
        public PublicKey parsePublicKey(String resourceKeyFormat) {
            try {
                return SecurityUtils.loadPublicKeyPEMResource(resourceKeyFormat);
            } catch (Exception e) {
                return null;
            }
        }
    };
}