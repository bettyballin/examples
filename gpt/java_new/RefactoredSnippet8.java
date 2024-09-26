import java.math.BigInteger;

public class RefactoredSnippet8 {
    public static void main(String[] args) {
        BigInteger g = ...; // Your value of g
        BigInteger y = ...; // Your value of y
        BigInteger u1 = ...; // Your value of u1
        BigInteger u2 = ...; // Your value of u2
        BigInteger p = ...; // Your value of p

        // Perform modular exponentiation for both terms
        BigInteger term1 = g.modPow(u1, p);
        BigInteger term2 = y.modPow(u2, p);

        // Multiply the terms (still mod p)
        BigInteger product = term1.multiply(term2).mod(p);

        // Use product as needed
    }
}