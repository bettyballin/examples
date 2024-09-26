import java.math.BigInteger;

public class Temp1393 {
    public static void main(String[] args) {
        BigInteger Qy = new BigInteger("10"); // Example value for Q.y
        BigInteger thisY = new BigInteger("5"); // Example value for this.y
        BigInteger Qx = new BigInteger("20"); // Example value for Q.x
        BigInteger thisX = new BigInteger("15"); // Example value for this.x
        BigInteger p = new BigInteger("23"); // Example value for ec.p

        BigInteger lambda = (Qy.subtract(thisY).modInverse(p)).multiply(Qx.subtract(thisX)).mod(p);

        System.out.println("Lambda: " + lambda);
    }
}