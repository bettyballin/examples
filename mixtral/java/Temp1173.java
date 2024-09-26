import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class Temp1173 {
    private static final String ENCRYPT_KEY = "00112233445566778899AABBCCDDEEFF"; // example key
    private static final String IVKEY = "0102030405060708090A0B0C0D0E0F10"; // example IV

    public static void main(String[] args) {
        byte[] keyBytes = DatatypeConverter.parseHexBinary(ENCRYPT_KEY);
        byte[] ivBytes  = DatatypeConverter.parseHexBinary(IVKEY);

        IvParameterSpec iv = new IvParameterSpec(ivBytes);
        SecretKeySpec skSpec = new SecretKeySpec(keyBytes, "AES");

        // Example usage (just for demonstration)
        System.out.println("IV: " + DatatypeConverter.printHexBinary(iv.getIV()));
        System.out.println("SecretKeySpec Algorithm: " + skSpec.getAlgorithm());
    }
}