import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFileExample {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File("idontknowwhattodo.txt"));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                System.out.println(line);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}