import java.util.Scanner;

public class BuggyCode {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        char[] thisArray = new char[150];

        System.out.println("Enter some characters. We are going to do this for a while");
        String input1 = kb.nextLine();
        if (input1.length() > 0) {
            thisArray[0] = input1.charAt(0);
        }

        System.out.println("Enter some more characters.");
        String input2 = kb.nextLine();
        for (int i = 10; i < 20; ++i) {
            if (input2.length() > i - 10)
                thisArray[i] = input2.charAt(i - 10);
            else break;
        }

        for (int i = 0; i < 20; i++) {
            if (thisArray[i] != '\u0000') {
                System.out.print(thisArray[i] + " ");
            } else {
                System.out.print("  ");
            }
        }

    }
}