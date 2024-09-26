import java.util.Scanner;

public class Temp1679 {
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            // Your code here
            System.out.println("Enter something: ");
            String input = s.nextLine();
            System.out.println("You entered: " + input);
        }
    }
}