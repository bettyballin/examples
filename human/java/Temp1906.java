import java.security.PrivateKey;
import java.security.Signature;

public class Temp1906 {
    public static void main(String[] args) {
        // Example usage (Note: This is a placeholder and won't run as is)
        // byte[] data = "example data".getBytes();
        // PrivateKey privateKey = ... // Obtain a valid PrivateKey instance
        // int saltLength = ... // Define the salt length
        // try {
        //     byte[] signature = sign(data, privateKey, saltLength);
        //     // Process the signature bytes
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

    static public byte[] sign(byte[] data, PrivateKey privateKey, int saltLength) throws Exception {
        Signature instance = Signature.getInstance("SHA256withRSA");
        instance.initSign(privateKey);
        instance.update(data);
        return instance.sign();
    }
}