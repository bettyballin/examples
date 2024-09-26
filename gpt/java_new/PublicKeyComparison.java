import java.security.PublicKey;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Objects;

public class PublicKeyComparison {

    public static PublicKey convertStringToPublicKey(String publicKeyString) throws Exception {
        byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePublic(keySpec);
    }

    public static boolean comparePublicKeys(PublicKey keyFromCertificate, String publicKeyStringFromLdap) {
        try {
            PublicKey keyFromLdap = convertStringToPublicKey(publicKeyStringFromLdap);
            return keyFromCertificate.equals(keyFromLdap);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Example usage
    public static void main(String[] args) {
        try {
            PublicKey certificateKey = // ... obtain public key from certificate
            String ldapPublicKeyString = // ... obtain public key string from LDAP
            boolean areEqual = comparePublicKeys(certificateKey, ldapPublicKeyString);
            System.out.println("Are the public keys equal? " + areEqual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}