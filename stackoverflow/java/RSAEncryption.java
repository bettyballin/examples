import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RSAEncryption {
    public static void main(String[] args) {
        String text = "Secret.";
        int p = 13;
        int q = 19;
        int z = (p - 1) * (q - 1);
        int e = 5;
        int d = 173;
        BigInteger n = BigInteger.valueOf(p * q);

        List<BigInteger> encryptedMessage = encryptMessage(text, e, n);
        String decryptedMessage = decryptMessage(encryptedMessage, d, n);

        System.out.println("Encrypted message is: " + encryptedMessage);
        System.out.println("Decrypted message is: " + decryptedMessage);
    }

    private static List<BigInteger> encryptMessage(String text, int e, BigInteger n) {
        List<BigInteger> encryptedText = new ArrayList<>();
        byte[] bytes = text.getBytes();

        for (byte b : bytes) {
            BigInteger encryptedByte = BigInteger.valueOf(b).modPow(BigInteger.valueOf(e), n);
            encryptedText.add(encryptedByte);
        }

        return encryptedText;
    }

    private static String decryptMessage(List<BigInteger> encryptedText, int d, BigInteger n) {
        byte[] decryptedBytes = new byte[encryptedText.size()];

        int i = 0;
        for (BigInteger encryptedByte : encryptedText) {
            decryptedBytes[i++] = encryptedByte.modPow(BigInteger.valueOf(d), n).byteValue();
        }

        return new String(decryptedBytes);
    }
}