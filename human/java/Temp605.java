import java.util.Base64;

public class Temp605 {
    public static void main(String[] args) {
        String username = "user";
        String raw_password = "password";
        String concatenated = username + ":" + raw_password;
        String schemeSpecificTextValue = base64Encode(concatenated.toCharArray());
        System.out.println(schemeSpecificTextValue);
    }

    private static String base64Encode(char[] input) {
        return Base64.getEncoder().encodeToString(new String(input).getBytes());
    }
}