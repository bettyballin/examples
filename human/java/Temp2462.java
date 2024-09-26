import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Arrays;

public class Temp2462 {
    public static void main(String[] args) {
        try {
            // Example RSA parameters
            BigInteger modulus = new BigInteger("00af792b50b2b8e6f1eac3f0d5a4e5b0a67c7ab3a6a6fb6c8bf3f9e1db5a3c8e3e6f3b7c5d7b4a3f7c3b6a5e6f4d3c2b1a0f3e6d5c4b3a2a1b0e1f2d3c4b5a6", 16);
            BigInteger exponent = new BigInteger("010001", 16);
            BigInteger d = new BigInteger("00d8e3b2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0", 16);
            BigInteger p = new BigInteger("00d3e2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0", 16);
            BigInteger q = new BigInteger("00e2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0", 16);
            BigInteger dp = new BigInteger("00f3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0", 16);
            BigInteger dq = new BigInteger("00c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2c1f0e3d2", 16);
            BigInteger inverseQ = new BigInteger("00b1a2c3d4e5f6a7b8c9d0e1f2a3b4c5d6e7f8a9b0c1d2e3f4a5b6c7d8e9f0a1b2c3d4e5f6a7b8c9d0e1f2a3b4c5d6e7f8a9b0c1d2e3f4a5b6c