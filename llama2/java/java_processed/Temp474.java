import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class Temp474 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator serverKpairGen = KeyPairGenerator.getInstance("RSA", "SunRsaSign");
            serverKpairGen.initialize(2048);
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}