import java.math.BigInteger;
import java.util.Arrays;

public class Temp3075 {
    public static void main(String[] args) {
        byte[] num1 = {1, 2, 3, 4};
        byte[] num2 = {5, 6, 7, 8};
        BigInteger p = new BigInteger("23");
        byte[] result = multiplyElGamal(num1, num2, p);
        System.out.println(Arrays.toString(result));
    }

    public static byte[] multiplyElGamal(byte[] num1, byte[] num2, BigInteger p) {
        byte[] a1 = Arrays.copyOfRange(num1, 0, num1.length / 2);
        byte[] b1 = Arrays.copyOfRange(num1, num1.length / 2, num1.length);
        byte[] a2 = Arrays.copyOfRange(num2, 0, num2.length / 2);
        byte[] b2 = Arrays.copyOfRange(num2, num2.length / 2, num2.length);

        byte[] part1 = new BigInteger(1, a1).multiply(new BigInteger(1, a2)).mod(p).toByteArray();
        byte[] part2 = new BigInteger(1, b1).multiply(new BigInteger(1, b2)).mod(p).toByteArray();

        byte[] result = new byte[part1.length + part2.length];
        System.arraycopy(part1, 0, result, 0, part1.length);
        System.arraycopy(part2, 0, result, part1.length, part2.length);

        return result;
    }
}