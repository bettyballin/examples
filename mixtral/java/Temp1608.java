import java.util.Base64;

public class Temp1608 {
    public static void main(String[] args) {
        byte[] originalBytes = getEncryptedPasswordFromString("your_base64_string", yourDerivedKeyLength);
    }

    public static byte[] getEncryptedPasswordFromString(String encoded, int derivedKeyLength) {
        return Base64.getDecoder().decode(encoded);
    }
}