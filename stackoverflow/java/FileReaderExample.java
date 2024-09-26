import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderExample {
    public static void main(String[] args) {
        String word = "";
        String word2 = "";
        Scanner input = null;

        try {
            input = new Scanner(new File("idontknowwhattodo.txt"));
            while (input.hasNextLine()) {
                // Your code to process the file line by line goes here
                // For example:
                // String line = input.nextLine();
                // Process the line
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }
}