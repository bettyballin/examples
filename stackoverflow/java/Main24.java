import java.util.Scanner;
import java.util.List;

public class Main24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int generateur = 0;
        List<Integer> facteur = null; // This should be initialized with actual factors
        int nombre = 0; // This should be initialized with the actual number

        boolean etape = true;
        while (etape) {
            etape = false;
            System.out.println("Entrer un generateur :");
            generateur = sc.nextInt();

            double b;
            for (int s = 0; s < facteur.size(); s++) {
                b = Math.pow(generateur, (nombre / facteur.get(s))) % (nombre + 1);
                System.out.println("b= " + b);
                if (b == 1) {
                    etape = true;
                    break;
                }
            }
        }

        sc.close();
        // Rest of your code...
    }
}