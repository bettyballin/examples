public class Temp1208 {
    public static void main(String[] args) {
        String text = "Hello, World!";
        int shift = 3; // Example shift value
        String text_dec = "";
        
        char[] stringToCharArray = text.toCharArray();

        for (char output : stringToCharArray) {
            int ascii = (int) output;

            // Only apply shifts to printable ASCII characters
            if (ascii >= 32 && ascii <= 126) {
                ascii += shift;

                while (ascii < 32 || ascii > 126) {
                    if (ascii < 32)
                        ascii = ((ascii - 32 + 95)) % 94 + 32;
                    else
                        ascii -= 94;
                }
            }

            // Convert back to ASCII
            char chTemp = (char) ascii;

            text_dec += chTemp;
        }

        System.out.println("Original Text: " + text);
        System.out.println("Shifted Text: " + text_dec);
    }
}