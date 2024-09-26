public class CustomEncoding {
    private static final int ASCII_START = 32;
    private static final int ASCII_END = 126;

    public String encode(String input, char[] encodedChars) {
        StringBuilder output = new StringBuilder();

        for (char c : input.toCharArray()) {
            if ((int)c >= ASCII_START && (int)c <= ASCII_END) {
                int index = (int)c - ASCII_START;
                output.append(encodedChars[index]);
            } else {
                // Handle non-ASCII characters as needed
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        char[] originalChars = new char[ASCII_END - ASCII_START + 1];
        char[] encodedChars = new char[ASCII_END - ASCII_START + 1];

        // Example encoding: shift each character by 1 in ASCII table
        for (int i = ASCII_START; i <= ASCII_END; i++) {
            originalChars[i - ASCII_START] = (char)i;
            encodedChars[i - ASCII_START] = (char)(i + 1);
        }

        CustomEncoding encoder = new CustomEncoding();
        String input = "Hello, World!";
        String encoded = encoder.encode(input, encodedChars);
        System.out.println("Encoded: " + encoded);
    }
}