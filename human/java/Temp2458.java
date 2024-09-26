import java.security.*;
import java.util.Arrays;

public class Temp2458 {
    private static byte[] s_prefix =
    {
        0x30, (byte)0x82, 0x01, 0x22,
        0x30, 0x0D,
        0x06, 0x09, 0x2A, (byte)0x86, 0x48, (byte)0x86, (byte)0xF7, 0x0D, 0x01, 0x01, 0x01,
        0x05, 0x00,
        0x03, (byte)0x82, 0x01, 0x0F,
        0x00,
        0x30, (byte)0x82, 0x01, 0x0A,
        0x02, (byte)0x82, 0x01, 0x01, 0x00
    };

    private static byte[] s_suffix = { 0x02, 0x03, 0x01, 0x00, 0x01 };

    private static byte[] MakeSubjectPublicInfoEasy2048(RSAPublicKey rsa) throws GeneralSecurityException {
        if (rsa.getModulus().bitLength() != 2048) {
            throw new IllegalArgumentException("Invalid RSA key size");
        }

        byte[] exponent = rsa.getPublicExponent().toByteArray();
        if (!Arrays.equals(exponent, new byte[]{0x01, 0x00, 0x01})) {
            throw new IllegalArgumentException("Invalid RSA exponent");
        }

        byte[] modulus = rsa.getModulus().toByteArray();
        byte[] result = new byte[s_prefix.length + modulus.length + s_suffix.length];
        System.arraycopy(s_prefix, 0, result, 0, s_prefix.length);
        System.arraycopy(modulus, 0, result, s_prefix.length, modulus.length);
        System.arraycopy(s_suffix, 0, result, s_prefix.length + modulus.length, s_suffix.length);

        return result;
    }

    public static void main(String[] args) {
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            KeyPair keyPair = keyGen.generateKeyPair();
            RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();

            byte[] subjectPublicInfo = MakeSubjectPublicInfoEasy2048(publicKey);
            // Print the result or use it as needed
            System.out.println(Arrays.toString(subjectPublicInfo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}