import java.util.HashMap;
import java.util.Map;

public class CustomEncodingDecoding {
    public static void main(String[] args) {
        String inputText = "Hello World!";
        Map<Character, Character> encodingMap = new HashMap<>();
        // Initialize the map with custom mappings provided by your client.
        encodingMap.put('H', 'X');
        encodingMap.put('e', 'Y');
        encodingMap.put('l', 'l');
        encodingMap.put('o', 'o');
        encodingMap.put(' ', ' ');
        encodingMap.put('W', 'W');
        encodingMap.put('r', 'r');
        encodingMap.put('d', 'd');
        encodingMap.put('!', '!');

        System.out.println("Encoded Text: " + encode(inputText, encodingMap));

        String encodedText = "XYllo World!";
        Map<Character, Character> decodingMap = new HashMap<>();
        // Initialize the map with inverse mappings for decryption.
        decodingMap.put('X', 'H');
        decodingMap.put('Y', 'e');
        decodingMap.put('l', 'l');
        decodingMap.put('o', 'o');
        decodingMap.put(' ', ' ');
        decodingMap.put('W', 'W');
        decodingMap.put('r', 'r');
        decodingMap.put('d', 'd');
        decodingMap.put('!', '!');

        System.out.println("Decoded Text: " + decode(encodedText, decodingMap));
    }

    public static String encode(String inputText, Map<Character, Character> encodingMap) {
        StringBuilder encodedText = new StringBuilder();
        for (char c : inputText.toCharArray()) {
            if (encodingMap.containsKey(c)) {
                encodedText.append(encodingMap.get(c));
            } else {
                encodedText.append(c);
            }
        }
        return encodedText.toString();
    }

    public static String decode(String encodedText, Map<Character, Character> decodingMap) {
        StringBuilder decodedText = new StringBuilder();
        for (char c : encodedText.toCharArray()) {
            if (decodingMap.containsKey(c)) {
                decodedText.append(decodingMap.get(c));
            } else {
                decodedText.append(c);
            }
        }
        return decodedText.toString();
    }
}