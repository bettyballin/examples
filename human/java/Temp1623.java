import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Temp1623 {
    public static void main(String[] args) {
        String word = "";
        String word2 = "";
        try {
            Scanner input = new Scanner(new File("idontknowwhattodo.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                // Process the line as needed
                System.out.println(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}