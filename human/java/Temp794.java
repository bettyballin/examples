import java.math.BigInteger;

public class Temp794 {
    public static void main(String[] args) {
        // Example BigInteger values
        BigInteger x = new BigInteger("123456789");
        BigInteger y = new BigInteger("987654321");
        BigInteger p = new BigInteger("111111111");
        BigInteger g = new BigInteger("333333333");

        byte[] xBytes = x.toByteArray();
        byte[] yBytes = y.toByteArray();
        byte[] pBytes = p.toByteArray();
        byte[] gBytes = g.toByteArray();
        
        // Just to have some output to indicate execution
        System.out.println("xBytes: " + java.util.Arrays.toString(xBytes));
        System.out.println("yBytes: " + java.util.Arrays.toString(yBytes));
        System.out.println("pBytes: " + java.util.Arrays.toString(pBytes));
        System.out.println("gBytes: " + java.util.Arrays.toString(gBytes));
    }
}