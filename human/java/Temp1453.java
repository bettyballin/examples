import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.RSAPublicKeySpec;

public class Temp1453 {
    public static void main(String[] args) {
        try {
            byte[] modulus = new byte[] { (byte) 0x00, (byte) 0xa3, (byte) 0x5b, (byte) 0xe3 }; // Example modulus byte array
            byte[] exponent = new byte[] { (byte) 0x01, (byte) 0x00, (byte) 0x01 }; // Example exponent byte array
            
            BigInteger modBigInteger = new BigInteger(1, modulus);
            BigInteger exBigInteger = new BigInteger(1, exponent);

            RSAPublicKeySpec spec = new RSAPublicKeySpec(modBigInteger, exBigInteger);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = factory.generatePublic(spec);

            System.out.println("Public Key: " + publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}