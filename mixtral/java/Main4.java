import java.io.*;
import java.util.*;

public class Main {
    public static void printDuplicate(Scanner input) throws Exception {
        String word = "";
        String word2 = "";

        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());

            int repeat = 1;

            if (!line.hasNext()) continue;

            word = line.next();

            while (line.hasNext()) {
                word2 = line.next();

                // Check for consecutive duplicates
                while (word.equals(word2)) {
                    repeat++;

                    if (!line.hasNext()) break;

                    word2 = line.next();
                }

                // Print the duplicate token and its count
                if (repeat > 1) {
                    System.out.println(word + " " + repeat);
                }

                word = word2;
                repeat = 1;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String data = "this this is a a a test test data data data data";
        Scanner input = new Scanner(new ByteArrayInputStream(data.getBytes()));
        printDuplicate(input);
    }
}