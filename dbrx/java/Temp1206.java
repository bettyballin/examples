import java.math.BigInteger;

public class Temp1206 {
    public static void main(String[] args) {
        byte[] msgBytes = { 1, 2, 3, 4 }; // Example byte array
        BigInteger messageInt = new BigInteger(1, msgBytes);
        System.out.println("BigInteger value: " + messageInt);
    }
}