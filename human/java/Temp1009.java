import java.security.*;
import java.security.spec.*;
import javax.crypto.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp1009 {
    public static void main(String[] args) {
        try {
            final Provider bc = new BouncyCastleProvider();
            Security.addProvider(bc);

            // Dummy RSA key parameters (for illustration purposes only)
            BigInteger modulus = new BigInteger("00af795a9e3b8f2c5e8a5c4a5f695a8ed1a5d5e7b1a7a3d6f0a7b1e7f5e5d3c1f9d7e9b5a8f5c5a7e9b5a7e5f7e9d5c5b7a3d5f0", 16);
            BigInteger privateExponent = new BigInteger("00d4e5f6c7b8a9d0e1f2c3b4a5e6d7c8b9a0d1f2e3c4b5a6d7e8f9c0b1a2e3d4c5b6a7d8e9f0c1d2e3f4b5a6c7d8e9f0c1d2b3a4", 16);

            // generating the key from modulus and private exponent
            KeyFactory rsaFactory = KeyFactory.getInstance("RSA", bc);
            RSAPrivateKeySpec spec = new RSAPrivateKeySpec(modulus, privateExponent);
            RSAPrivateKey testKey = (RSAPrivateKey) rsaFactory.generatePrivate(spec);

            // using it in a raw cipher
            Cipher c = Cipher.getInstance("RSA/ECB/NoPadding", bc);
            c.init(Cipher.DECRYPT_MODE, testKey);
            byte[] result = c.doFinal(new byte[] {
                (byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, 
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF
            });

            // Print the result
            System.out.println("Decryption result: " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}