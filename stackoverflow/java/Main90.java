import com.macasaet.fernet.Key;
import com.macasaet.fernet.StringValidator;
import com.macasaet.fernet.Token;
import com.macasaet.fernet.Validator;

public class Main90 {
    static final Validator<String> validator = new StringValidator() {
    };

    public static void main(String[] args) {
        // generate a key
        Key key = Key.generateKey();
        System.out.println("key: " + key.serialise());
        // encrypt
        String plaintext = "this is my data that needs encryption";
        Token token = Token.generate(key, plaintext);
        System.out.println("token: " + token.serialise());
        // decrypt
        System.out.println("token timestamp: " + token.getTimestamp());
        String decryptedtext = token.validateAndDecrypt(key, validator);
        System.out.println("decryptedtext: " + decryptedtext);
        // old token
        try {
            Token token2 = Token.fromString("gAAAAAAdwJ6wAAECAwQFBgcICQoLDA0ODy021cpGVWKZ_eEwCGM4BLLF_5CV9dOPmrhuVUPgJobwOz7JcbmrR64jVmpU4IwqDA==");
            System.out.println("token2 timestamp: " + token2.getTimestamp());
            String decryptedtext2 = token2.validateAndDecrypt(key, validator);
            System.out.println("decryptedtext2: " + decryptedtext2);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid token string");
        }
    }
}