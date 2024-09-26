import javax.xml.bind.DatatypeConverter;

public class Temp1397 {
    public static void main(String[] args) {
        String plainText = "The plain text information";
        byte[] pBytes = plainText.getBytes();
        int[] pInts = new int[pBytes.length];
        for (int i = 0; i < pBytes.length; ++i) {
            pInts[i] = Byte.toUnsignedInt(pBytes[i]);
        }

        String keyStr = "000102030405060708090A0B0C0D0E0F";
        byte[] kBytes = DatatypeConverter.parseHexBinary(keyStr);
        int[] kInts = new int[kBytes.length];
        for (int i = 0; i < kBytes.length; ++i) {
            kInts[i] = Byte.toUnsignedInt(kBytes[i]);
        }

        System.out.println("Input:");
        Utils.printInput(pInts);

        // Use the key and plaintext arrays for encryption
        // ...
    }
}

class Utils {
    public static void printInput(int[] input) {
        for (int i : input) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}