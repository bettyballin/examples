public class Temp414 {
    public static void main(String[] args) {
        String original = "example"; // Define the original string
        String obfuscated = "eXaXmXpXlXeX"; // Define the obfuscated string

        StringBuilder sbDeObfuscated = new StringBuilder();
        for (int i = 0; i < original.length() * 3 - original.length(); ++i) {
            if ((i + 1) % 3 == 0) {
                char c = obfuscated.charAt(i);
                sbDeObfuscated.append(c);
            }
        }

        System.out.println(sbDeObfuscated.toString());
    }
}