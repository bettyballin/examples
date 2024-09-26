import java.util.Scanner;

public class Temp2736 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the text to be encrypted and decrypted");
        String plaintext = scanner.nextLine();

        System.out.println("Enter 1st prime number p");
        int p = scanner.nextInt();

        System.out.println("Enter 2nd prime number q");
        int q = scanner.nextInt();

        int n = p * q;
        int z = (p - 1) * (q - 1);

        int e = 5; // This should be chosen such that 1 < e < z and gcd(e, z) = 1
        int d = 173; // This should be chosen such that (d * e) % z = 1

        System.out.println("the value of z = " + z);
        System.out.println("the value of e = " + e);
        System.out.println("the value of d = " + d);

        int[] plaintextNumbers = new int[plaintext.length()];
        for (int i = 0; i < plaintext.length(); i++) {
            plaintextNumbers[i] = plaintext.charAt(i);
        }

        System.out.print("Plain text as sequence of numbers: ");
        for (int num : plaintextNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        double[] encryptedMessage = new double[plaintextNumbers.length];
        for (int i = 0; i < plaintextNumbers.length; i++) {
            encryptedMessage[i] = Math.pow(plaintextNumbers[i], e) % n;
        }

        System.out.print("Encrypted message is: ");
        for (double num : encryptedMessage) {
            System.out.print(num + " ");
        }
        System.out.println();

        char[] decryptedMessage = new char[encryptedMessage.length];
        for (int i = 0; i < encryptedMessage.length; i++) {
            decryptedMessage[i] = (char) (Math.pow(encryptedMessage[i], d) % n);
        }

        System.out.print("Decrypted message is: ");
        for (char ch : decryptedMessage) {
            System.out.print(ch);
        }
        System.out.println();

        scanner.close();
    }
}