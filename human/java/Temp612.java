import static java.lang.Character.digit;

public class Temp612 {
    public static void main(String[] args) {
        String keyExample = "99112277445566778899AABBCCDDEEFF0123456789ABCDEF0123456789ABCDEF";
        byte[] key = stringToBytes(keyExample);    
        byte[] barrayMessage = {123,45,55,23,64,21,65};    
        byte[] result = decryptByte(barrayMessage, key);
        
        // Print result for demonstration purposes
        for (byte b : result) {
            System.out.print(b + " ");
        }
    }

    private static byte[] stringToBytes(String input) {
        int length = input.length();
        byte[] output = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            output[i / 2] = (byte) ((digit(input.charAt(i), 16) << 4) | digit(input.charAt(i+1), 16));
        }
        return output;
    }

    private static byte[] decryptByte(byte[] message, byte[] key) {
        // Dummy decryption logic for example purposes
        byte[] decryptedMessage = new byte[message.length];
        for (int i = 0; i < message.length; i++) {
            decryptedMessage[i] = (byte) (message[i] ^ key[i % key.length]);
        }
        return decryptedMessage;
    }
}