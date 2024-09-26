import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder decryptedMessage = new StringBuilder();

        while (s.hasNextLine()) {
            String line = s.nextLine();
            String[] parts = line.split("\\*");

            for (String part : parts) {
                if (!part.isEmpty()) {
                    char letter = part.charAt(part.length() - 1);
                    if (Character.isLetter(letter) || letter == ' ') {
                        decryptedMessage.append(letter);
                    }
                }
            }
        }
        s.close();
        System.out.println(decryptedMessage.toString());
    }
}