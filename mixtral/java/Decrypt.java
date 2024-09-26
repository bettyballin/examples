import java.util.*;

public class Decrypt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNextLine()) {
            String word = s.nextLine();

            // Split the input by "*"
            String[] temp = word.split("\\*");

            for (int i = 1; i < temp.length; ++i) {
                System.out.print((char) (Integer.parseInt(String.valueOf(temp[i].charAt(0))) + 'a' - 1));
            }

            // Print the last character as is
            if (word.endsWith("*"))
                System.out.println();
        }
        s.close();
    }
}