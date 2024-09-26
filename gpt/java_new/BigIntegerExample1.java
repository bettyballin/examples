// Without a code snippet to refactor, here's a simple class using BigInteger for demonstration.
public class BigIntegerExample1 {
    public static void main(String[] args) {
        BigInteger bigInt = new BigInteger("123456789");
        BigInteger result = bigInt.multiply(new BigInteger("987654321"));
        System.out.println("Result of the multiplication: " + result);
    }
}