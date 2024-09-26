import java.util.Base64;

public class Temp1861 {
    public static void main(String[] args) {
        String privateKeyStr = "yourPrivateKeyStringHere";
        String publicKeyStr = "yourPublicKeyStringHere";

        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyStr);
        byte[] publicKeyBytes  = Base64.getDecoder().decode(publicKeyStr);
        
        // For demonstration, print the lengths of the byte arrays
        System.out.println("Private Key Bytes Length: " + privateKeyBytes.length);
        System.out.println("Public Key Bytes Length: " + publicKeyBytes.length);
    }
}