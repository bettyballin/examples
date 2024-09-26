import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;

public class Temp948 {
    public static void main(String[] args) {
        try {
            // Example private key parameters, replace with actual values
            RSAKeyParameters privateKey = new RSAPrivateCrtKeyParameters(
                    /* modulus= */ new java.math.BigInteger("modulus_value_here"),
                    /* publicExponent= */ new java.math.BigInteger("public_exponent_value_here"),
                    /* privateExponent= */ new java.math.BigInteger("private_exponent_value_here"),
                    /* p= */ new java.math.BigInteger("p_value_here"),
                    /* q= */ new java.math.BigInteger("q_value_here"),
                    /* dp= */ new java.math.BigInteger("dp_value_here"),
                    /* dq= */ new java.math.BigInteger("dq_value_here"),
                    /* qInv= */ new java.math.BigInteger("qInv_value_here")
            );

            byte[] message = "Your message here".getBytes();

            RSABlindedEngine engine = new RSABlindedEngine();
            PKCS1Encoding paddedEngine = new PKCS1Encoding(engine);
            paddedEngine.init(true, privateKey);

            byte[] encryptedMessage = paddedEngine.processBlock(message, 0, message.length);

            // Output the encrypted message
            System.out.println(java.util.Base64.getEncoder().encodeToString(encryptedMessage));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}