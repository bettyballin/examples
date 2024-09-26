import java.util.Base64;

public class Temp1860 {
    public static void main(String[] args) {
        byte[] privateKeyBytes = new byte[]{ /* your private key bytes here */ };
        byte[] publicKeyBytes = new byte[]{ /* your public key bytes here */ };

        String privateKeyStr = Base64.getEncoder().encodeToString(privateKeyBytes);
        String publicKeyStr  = Base64.getEncoder().encodeToString(publicKeyBytes);

        System.out.println("Private Key: " + privateKeyStr);
        System.out.println("Public Key: " + publicKeyStr);
    }
}