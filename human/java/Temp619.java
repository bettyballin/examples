import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Temp619 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> facteur = new ArrayList<>();
        boolean etape = true;
        int generateur = 0;
        int nombre = 100; // Example value, you can set it to what you need
        double b;

        // Example values for facteur list
        facteur.add(2);
        facteur.add(5);
        facteur.add(10);

        while (etape) {
            etape = false;
            System.out.println("Entrer un generateur :");
            generateur = sc.nextInt();

            for (int s = 0; s < facteur.size(); s++) {
                b = Math.pow(generateur, (nombre / facteur.get(s))) % (nombre + 1);
                System.out.println("b= " + b);
                if (b == 1) {
                    etape = true;
                    break;
                }
            }
        }
        System.out.println("Generateur final: " + generateur);
        sc.close();
    }
}