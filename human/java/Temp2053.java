import java.security.*;
import java.security.spec.*;

public class Temp2053 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("EC");
            kpGen.initialize(new ECGenParameterSpec("secp384r1"));
            KeyPair ecKP = kpGen.generateKeyPair();

            // For demonstration purposes, print out the generated key pair
            System.out.println("Private Key: " + ecKP.getPrivate());
            System.out.println("Public Key: " + ecKP.getPublic());
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}