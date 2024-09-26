import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.security.spec.ECGenParameterSpec;

public class Temp2469 {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
            keyGen.initialize(new ECGenParameterSpec("sect571k1"));
            KeyPair keyPair = keyGen.generateKeyPair();

            Signature sig = Signature.getInstance("SHA256withECDSA");
            sig.initSign(keyPair.getPrivate());

            String message = "Test message";
            sig.update(message.getBytes());
            byte[] signature = sig.sign();

            System.out.println("Signature: " + bytesToHex(signature));

            sig.initVerify(keyPair.getPublic());
            sig.update(message.getBytes());
            boolean isValid = sig.verify(signature);

            System.out.println("Signature valid: " + isValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}