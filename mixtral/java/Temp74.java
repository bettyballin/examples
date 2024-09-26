public class Temp74 {
    public static void main(String[] args) {
        String input = "Hello, World!";
        int asciiShift = 3;
        String shiftedString = shiftCharsInStringByAsciiValue(input, asciiShift);
        System.out.println(shiftedString);
    }

    public static String shiftCharsInStringByAsciiValue(String input, int asciiShift) {
        StringBuilder output = new StringBuilder();

        for (char ch : input.toCharArray()) {
            char shiftedChar = (char) ((int) ch + asciiShift);

            // If the character is a letter and it goes out of bounds wrap around
            if (Character.isLetter(ch)) {
                int baseAsciiValue;

                if ('a' <= ch && ch <= 'z') {
                    baseAsciiValue = (int) 'a';

                    // If the character goes below a wrap around to z
                    while ((int) shiftedChar < baseAsciiValue) {
                        shiftedChar += ('z' - baseAsciiValue + 1);
                    }
                    while ((int) shiftedChar > 'z') {
                        shiftedChar -= ('z' - baseAsciiValue + 1);
                    }

                } else if ('A' <= ch && ch <= 'Z') {
                    baseAsciiValue = (int) 'A';

                    // If the character goes below A wrap around to Z
                    while ((int) shiftedChar < baseAsciiValue) {
                        shiftedChar += ('Z' - baseAsciiValue + 1);
                    }
                    while ((int) shiftedChar > 'Z') {
                        shiftedChar -= ('Z' - baseAsciiValue + 1);
                    }
                }
            }

            output.append(shiftedChar);
        }

        return output.toString();
    }
}