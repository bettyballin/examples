import java.util.Scanner;

public class Main51 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        char[] input = new char[150];
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter some characters. We are going to do this for a while.");
            char[] buf = kb.nextLine().toCharArray();
            System.arraycopy(buf, 0, input, i * 10, Math.min(buf.length, 10));
        }
        kb.close();
    }
}