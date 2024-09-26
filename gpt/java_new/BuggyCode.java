import java.util.Scanner;

public class BuggyCode {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        char[] thisArray = new char[10];

        for (int i = 0; i < thisArray.length; i++) {
            System.out.println("Enter some characters:");
            String input = kb.nextLine();
            
            if (input.length() > 0) {
                thisArray[i] = input.charAt(0);
            } else {
                thisArray[i] = ' ';
            }
        }
        
        kb.close();
    }
}