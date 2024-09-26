import java.util.Base64;
import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Temp3288 {
    public static void main(String[] args) {
        try {
            String privateKeyPEM = "-----BEGIN PRIVATE KEY-----\n"
                    + "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAM2+z+pQyOR+rYT2\n"
                    + "jSqfTf4okTsBJzMRufqr6SS2E0F2ZOyySKRazKSkM+ctaEBWSaPPhqVDKrD6Ydg/\n"
                    + "3GHHypQLgDe1djQ5vEA1RQqFS9HvM2Pi+Ti3wXac/d6ta9obwn6w3dRuvjRlghgt\n"
                    + "LpQdhEWupEMIOFS3KPARGXPwqEvJAgMBAAECgYADxGqqL7B9/pPOy3TqQuB6tuNx\n"
                    + "4SOGm9x76onqUisoF7LhYqJR4Be/LAKHSR2PkATpKvOcMw6lDvCbtQ+j+rSK2PkN\n"
                    + "4iDi1RYqbLUbZBS8vhrgU0CPlmgSSp1NBsqMK9265CaJox3frxmBK1yuf22RboIK\n"
                    + "pqOzcluuA4aqLegmwQJBAP0+gM/tePzx+53DrxpYQvlfi9UJo7KeqIFL8TjMziKt\n"
                    + "EaRGeOZ6UX/r6CQHojYKnNti7pjAwonsdwCTcv1yy7sCQQDP+/ww49VFHErON/MO\n"
                    + "w5iYCsrM5Lx+Yc2JAjetCDpkMrRT92cgQ0nxR5+jNeh+gE2AmB9iKlNxsHJoRaPQ\n"
                    + "lBRLAkEAl9hiZEp/wStXM8GhvKovfldMAPFGtlNrthtTCDvFXgVoDpgy5f9x3sIU\n"
                    + "74WkPcMfSmyHpA/wlcKzmCTRTicHAQJBALUjq7MQ2tAEIgqUo/W52I6i55mnpZsU\n"
                    + "pyOqcL8cqW5W0sNGd+SbdizTym8lJkX2jIlw8/RVFLOxjxLNhCzGqx0CQQDeUMnw\n"
                    + "7KGP3F7BnbsXCp64YDdihzSO5X/Mfwxw6+S/pyKZ0/X4uwt24kZuoDnFzGWJYlea\n"
                    + "sDQC6enIru+ne5es\n"
                    + "-----END PRIVATE KEY-----";
            privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----\n", "")
                    .replace("-----END PRIVATE KEY-----", "").replaceAll("\\s", "");

            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            String cipherTextB64 = "WlozD9ojNRQafip41dpuuhBMe7ruH2FBWnMhbAaSuAtPDpHOUyKaAm6mO15BbvL3eTXyqfEQx29dYPJEbUr5T/WXs846PQN6g7Yv25EXGVbPCzc4aIbms76C1jP92wXNEGWMnu624Fq5W9MVXX75mfaY0Fjvrh5k/TFuO4AIxMk=";
            byte[] cipherText = Base64.getDecoder().decode(cipherTextB64);

            byte[] plainText = cipher