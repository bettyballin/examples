import java.math.BigInteger;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.spec.RSAPrivateCrtKeySpec;


public class Temp1354 {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.bin"))) {
            BigInteger modulus = (BigInteger) ois.readObject();
            BigInteger publicExponent = (BigInteger) ois.readObject();
            BigInteger privateExponent = (BigInteger) ois.readObject();
            BigInteger primeP = (BigInteger) ois.readObject();
            BigInteger primeQ = (BigInteger) ois.readObject();
            BigInteger primeExponentP = (BigInteger) ois.readObject();
            BigInteger primeExponentQ = (BigInteger) ois.readObject();
            BigInteger crtCoef = (BigInteger) ois.readObject();

            RSAPrivateCrtKeySpec rsaPrivateCrtyKeySpec = new RSAPrivateCrtKeySpec(
                    modulus,
                    publicExponent,
                    privateExponent,
                    primeP,
                    primeQ,
                    primeExponentP,
                    primeExponentQ,
                    crtCoef
            );

            // You can use rsaPrivateCrtyKeySpec as needed
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}