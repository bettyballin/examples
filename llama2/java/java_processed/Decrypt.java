import java.util.Scanner;

public class Decrypt {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNextLine()) {
            String word = s.nextLine();
            String[] temp = word.split("\\*");

            for (int i = 0; i < temp.length; i++) {
                if(temp[i].length() > 0) {
                    char firstChar = temp[i].charAt(0);
                    int sum = 0;

                    for (int j = 1; j < temp[i].length(); j++) {
                        sum += temp[i].charAt(j);
                    }

                    System.out.print(firstChar + " : " + sum + " ");

                    if (temp[i].contains(" ")) {
                        System.out.print(temp[i].substring(1));
                    }
                }
            }

            System.out.println();
        }
        s.close();
    }
}