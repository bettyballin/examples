import java.util.Random;

public class Temp413 {
    public static void main(String[] args) {

        String original = "John";
        int[] obfuscatedAsciiValues = new int[original.length()];

        for (int i = 0; i < original.length(); ++i) {
            char c = original.charAt(i);

            // Add an offset to the ASCII value
            int asciiValueWithOffset = ((int) c + 123456789) % Character.MAX_VALUE;

            obfuscatedAsciiValues[i] = asciiValueWithOffset;
        }

        StringBuilder sbObfuscated = new StringBuilder();
        for (int i = 0; i < obfuscatedAsciiValues.length; ++i) {
            char c = (char) (obfuscatedAsciiValues[i]);

            // Add random characters around the obfuscated character
            sbObfuscated
                    .append(getRandomCharacter())
                    .append(c)
                    .append(getRandomCharacter());
        }

        String obfuscated = sbObfuscated.toString();
        System.out.println("Obfuscated: " + obfuscated);
    }

    private static char getRandomCharacter() {
        Random random = new Random();
        return (char) (random.nextInt(26) + 'a');
    }
}