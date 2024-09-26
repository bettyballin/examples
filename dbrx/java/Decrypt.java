import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String word = s.nextLine();
            String[] temp = word.split("\\*");

            for (String t : temp) {
                if (!t.isEmpty() && t.trim().length() > 0 && t.charAt(0) == ' ') {
                    int sum = 0;
                    char[] chars = t.substring(1).toCharArray();

                    // Convert characters to ASCII values and subtract 64
                    for (char c : chars) {
                        sum += ((int) c - 64);
                    }

                    System.out.print((char) sum + " ");
                }
            }

            System.out.println();
        }
        s.close();
    }
}