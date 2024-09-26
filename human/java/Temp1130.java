public class Temp1130 {
    public static void main(String[] args) {
        byte[] key = {1, 2, 3, 4};
        byte[] input = {10, 20, 30, 40, 50};
        
        byte[] encrypted = encryptOrDecrypt(key, input);
        System.out.println("Encrypted: ");
        for(byte b : encrypted) {
            System.out.print(b + " ");
        }
        System.out.println();
        
        byte[] decrypted = encryptOrDecrypt(key, encrypted);
        System.out.println("Decrypted: ");
        for(byte b : decrypted) {
            System.out.print(b + " ");
        }
    }

    public static byte[] encryptOrDecrypt(byte[] key, byte[] input) {
        byte[] result = new byte[input.length];
        for(int i = 0; i < input.length; i++) {
            result[i] = (byte) (input[i] ^ key[i % key.length]);
        }
        return result;
    }
}