import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.MGF1ParameterSpec;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSAEncrypt {
    public static void main(String[] args) throws Exception {
        // Example public key in base64 encoded format
        String publicKeyStr = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAz5O5zOeI5yJ3gj+6lq+7"
                + "PZ8Yk6V8x0t6DqvR1Y7z5B+Wl7z5xw7x5V7z5c9E8f7z5M8f7z5X8d7z5e8d7z5e"
                + "7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e"
                + "8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z"
                + "5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d"
                + "7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e"
                + "8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z"
                + "5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d"
                + "7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e"
                + "8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z"
                + "5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d"
                + "7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e"
                + "8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z"
                + "5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5e8d7z5