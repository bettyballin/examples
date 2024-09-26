public class Temp630 {
    public static void main(String[] args) {
        String str = Cipher.encrypt("uwu", "wrongkey");
        System.out.println(str);
    }
}

class Cipher {
    public static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = (char) (text.charAt(i) + key.charAt(i % key.length()));
            result.append(c);
        }
        return result.toString();
    }
}