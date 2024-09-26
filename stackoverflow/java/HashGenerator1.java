import java.security.MessageDigest;

public class HashGenerator1 {
    public byte[] generateHASH(byte[] message) throws Exception {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(message);
    }
}