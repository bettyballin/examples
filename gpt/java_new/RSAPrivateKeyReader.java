import java.io.IOException;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;

public class RSAPrivateKeyReader {

    public RSAPrivateCrtKey readPrivateKeyFromFile(String fileName) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
            BigInteger modulus = (BigInteger) ois.readObject();
            BigInteger publicExponent = (BigInteger) ois.readObject();
            BigInteger privateExponent = (BigInteger) ois.readObject();
            BigInteger primeP = (BigInteger) ois.readObject();
            BigInteger primeQ = (BigInteger) ois.readObject();
            BigInteger primeExponentP = (BigInteger) ois.readObject();
            BigInteger primeExponentQ = (BigInteger) ois.readObject();
            BigInteger crtCoefficient = (BigInteger) ois.readObject();

            RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(
                    modulus,
                    publicExponent,
                    privateExponent,
                    primeP,
                    primeQ,
                    primeExponentP,
                    primeExponentQ,
                    crtCoefficient);

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return (RSAPrivateCrtKey) keyFactory.generatePrivate(keySpec);
        } catch (Exception e) {
            throw new IOException("Failed to read RSA private key", e);
        }
    }
}