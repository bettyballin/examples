import java.io.File;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.sshd.common.config.keys.AuthorizedKeyEntry;
import org.apache.sshd.common.config.keys.PublicKeyEntryResolver;

public class RefactoredSnippet7 {
    public static void main(String[] args) throws Exception {
        Map<String, List<PublicKey>> userKeysMap = new HashMap<>();
        List<String> users = Arrays.asList("Jim", "Sally", "Bob");
        
        for (String user : users) {
            List<PublicKey> usersKeys = new ArrayList<>();
            List<AuthorizedKeyEntry> authorizedKeyEntries = AuthorizedKeyEntry.readAuthorizedKeys(new File(user + "_authorized_keys"));
            if (authorizedKeyEntries != null) {
                for (AuthorizedKeyEntry ake : authorizedKeyEntries) {
                    PublicKey publicKey = ake.resolvePublicKey(null, PublicKeyEntryResolver.IGNORING);
                    if (publicKey != null) {
                        usersKeys.add(publicKey);
                    }
                }
            }
            userKeysMap.put(user, usersKeys);
        }
    }
}