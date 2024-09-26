public class Temp626 {

    public static void main(String[] args) {
        String str = Cipher.encrypt("uwu");
        System.out.println(str);
    }
}

class Cipher {
    public static String encrypt(String input) {
        // Simple Caesar Cipher for demonstration
        StringBuilder encrypted = new StringBuilder();
        for (char c : input.toCharArray()) {
            encrypted.append((char) (c + 3)); // Shift each character by 3
        }
        return encrypted.toString();
    }
}