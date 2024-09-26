import java.util.Base64;

public class Temp2783 {
    public static void main(String[] args) {
        String encodingFormat = "X.509";
        String base64SubjectPublicKeyInfo = "MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEDA0qMRpJwaJyJ4YDciMqWefvr/mwYvF1fKnblJl5DOqAh5XUXkdWvYRDTTs9hPoHfPaNWWC9I0hOGb6+JPNxVw==";
        
        byte[] decodedKey = Base64.getDecoder().decode(base64SubjectPublicKeyInfo);
        
        System.out.println("Encoding Format: " + encodingFormat);
        System.out.println("Decoded SubjectPublicKeyInfo: " + new String(decodedKey));
    }
}