import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class KeyGen {

    public void generate() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[32]; // 256 bit
        random.nextBytes(values);

        String hexKey = toHex(values);
        System.out.println("Key (Hex): " + hexKey);

        String binKey = toBin(values);
        System.out.println("Key (Bin): " + binKey);
    }

    private String toHex(byte[] values) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : values) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    private String toBin(byte[] values) {
        StringBuilder binString = new StringBuilder();
        for (byte b : values) {
            String bin = Integer.toBinaryString(0xff & b);
            while (bin.length() < 8) {
                bin = "0" + bin;
            }
            binString.append(bin);
        }
        return binString.toString();
    }

    public static void main(String[] args) {
        try {
            new KeyGen().generate();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}