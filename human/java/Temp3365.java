import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class Temp3365 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the file path: ");
        String filepath = scanner.nextLine();
        scanner.close();
        
        try {
            byte[] content = Files.readAllBytes(Paths.get(filepath));
            System.out.println("File content read successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}