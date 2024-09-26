import java.util.*;

public class RSA {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text to be encrypted and decrypted");
        String text = sc.nextLine();
        int p, q, n, z, e;
        System.out.println("Enter 1st prime number p");
        p = sc.nextInt();
        System.out.println("Enter 2nd prime number q");
        q = sc.nextInt();

        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("the value of z = " + z);

        for (e = 2; e < z; e++) {
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("the value of e = " + e);
        sc.close();
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}