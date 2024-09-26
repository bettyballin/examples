import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateCrtKeySpec;

public RSAPrivateCrtKey getPrivateKey(BigInteger modulus, BigInteger publicExponent, BigInteger privateExponent,
                                       BigInteger primeP, BigInteger primeQ, BigInteger primeExponentP,
                                       BigInteger primeExponentQ, BigInteger crtCoefficient) throws Exception {
    RSAPrivateCrtKeySpec rsaPrivateCrtKeySpec = new RSAPrivateCrtKeySpec(
            modulus, publicExponent, privateExponent, primeP, primeQ, primeExponentP, primeExponentQ, crtCoefficient);
    KeyFactory fact = KeyFactory.getInstance("RSA");
    RSAPrivateKey privateKey = (RSAPrivateKey) fact.generatePrivate(rsaPrivateCrtKeySpec);

    return (RSAPrivateCrtKey) privateKey;
}