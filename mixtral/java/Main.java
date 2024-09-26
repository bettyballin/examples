import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        char[] thisArray = new char[150];

        System.out.println("Enter some characters:");

        for (int i = 0; i < thisArray.length && kb.hasNextLine(); ++i) {
            String input = kb.nextLine().trim();

            if (!input.isEmpty())
                thisArray[i] = input.charAt(0);
        }

        // print the array
        for (int i = 0; i < thisArray.length && thisArray[i] != '\0'; ++i) {
            System.out.print(thisArray[i] + " ");
        }
    }
}