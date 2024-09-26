public class Temp719 {
    public static void main(String[] args) {
        final char[] key = {0x5f, 38, 3, 111, 110};
        final char[] input = {0x5f, 38, 3, 111, 110}; // Example input

        char[] decode(final char[] input) {
            final char[] output = new char[input.length];
            for (int i = 0; i < output.length; i++) {
                output[i] = (char)(input[i] ^ key[i % 5]);
            }
            return output;
        }

        char[] decoded = decode(input);
        System.out.println(decoded);
    }

    private static char[] decode(final char[] input) {
        final char[] key = {0x5f, 38, 3, 111, 110};
        final char[] output = new char[input.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = (char)(input[i] ^ key[i % 5]);
        }
        return output;
    }
}