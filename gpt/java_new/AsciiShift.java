public class AsciiShift {

    public static char asciiToChar(int asciiCode) {
        return (char) asciiCode;
    }

    public static String shiftStringByAscii(String input, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            int shiftedAscii = currentChar + shift;

            if (Character.isUpperCase(currentChar)) {
                shiftedAscii = (shiftedAscii - 'A' + 26) % 26 + 'A';
            } else if (Character.isLowerCase(currentChar)) {
                shiftedAscii = (shiftedAscii - 'a' + 26) % 26 + 'a';
            }

            result.append(asciiToChar(shiftedAscii));
        }

        return result.toString();
    }
}