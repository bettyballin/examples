import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Main87 {
    public static void main(String[] args) throws GeneralSecurityException {
        String pemString = "-----BEGIN PUBLIC KEY-----
MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDCnwiV6Opd+3TZf9N1z9GVhxtY
nqWiFRIsqUOR/vXXge8hbhgm5ITKfZtvyO92Lk+5Tl1Qdrb+OfNcKmBHkGUEdBib
XCNEXj7SOhQTBH0PnV++8+xJXoutsiJU9Z+sjMCFivbd5wgBizXcY8U9SQfYb+Iv
NQ8FBL4nV8lMiwAp8QIDAQAB
-----END PUBLIC KEY-----
";
        String base64 = toBase64DER(pemString);
        PublicKey publicKey = loadPublicKey(base64);
    }

    public static PublicKey loadPublicKey(String stored) throws GeneralSecurityException {
        byte[] data = Base64.getDecoder().decode(stored);
        X509EncodedKeySpec spec = new X509EncodedKeySpec(data);
        KeyFactory fact = KeyFactory.getInstance("RSA");
        return fact.generatePublic(spec);
    }

    public static String toBase64DER(String pem) {
        return pem.replace("-----BEGIN PUBLIC KEY-----
", "")
                  .replace("-----END PUBLIC KEY-----", "")
                  .replaceAll("\\s", "");
    }
}