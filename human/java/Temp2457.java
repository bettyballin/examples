public class Temp2457 {
    public static void main(String[] args) {
        byte[] Modulus = {0x01, 0x02, 0x7F, (byte)0x80, (byte)0xFF}; // Example Modulus array
        int modulusBytes = Modulus.length;

        if (Modulus[0] >= 0x80)
            modulusBytes++;

        System.out.println("Modulus Bytes: " + modulusBytes);
    }
}