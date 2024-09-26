import java.math.BigInteger;

public class Temp3444 {
    public static void main(String[] args) {
        BigInteger b = new BigInteger("123456789");
        BigInteger result = b.mod(new BigInteger("115792089237316195423570985008687907852837564279074904382605163141518161494337"));
        System.out.println(result);
    }
}