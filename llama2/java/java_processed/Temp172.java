import java.security.*;

public class Temp172 {
    public static void main(String[] args) {
        try {
            Signature sig = Signature.getInstance("SHA1withRSA", "SunRsaSign");
            System.out.println("Signature instance created: " + sig.getAlgorithm());
        } catch (NoSuchAlgorithmException | NoSuchProviderException e) {
            e.printStackTrace();
        }
    }
}