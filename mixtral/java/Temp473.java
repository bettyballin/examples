import java.util.Base64;

public class Temp473 {
    public static void main(String[] args) {
        String input = "U29tZUJhc2U2NEVuY29kZWRTdHJpbmc=";
        int maxLength = 10;
        String result = base64ToCode39(input, maxLength);
        System.out.println(result);
    }

    public static String base64ToCode39(String input, int maxLength) {
        // Define your allowed set of chars
        final char[] code39Chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z', '-', '.', ' ', '$',
            '/', '+', '%'
        };

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length() && maxLength > output.length(); ++i) {
            char c = input.charAt(i);

            // Convert the base64 character into a number
            int n = Base64.getDecoder().decode("" + c)[0];

            if (n < code39Chars.length) {
                output.append(code39Chars[n]);
            }
        }

        return output.toString();
    }
}