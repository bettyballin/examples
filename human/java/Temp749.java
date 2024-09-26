import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

import javax.crypto.Cipher;

public class Main {

    public static void main(String[] args) throws Exception {
        // Example usage
        byte[] x509key = {}; // Add your byte array here
        PublicKey publicKey = decodeX509PublicKey(x509key);
        if (publicKey != null) {
            System.out.println("Public Key decoded successfully.");
        } else {
            System.out.println("Failed to decode Public Key.");
        }
    }

    public static PublicKey decodeX509PublicKey(byte[] x509key) throws Exception {
        byte[] SeqOID = { 0x2A, (byte) 0x86, 0x48, (byte) 0x86, (byte) 0xF7, 0x0D, 0x01, 0x01, 0x01 };

        InputStream ms = new ByteArrayInputStream(x509key);
        BinaryReader reader = new BinaryReader(ms);

        if (reader.readByte() == 0x30)
            readASNLength(reader); // skip the size
        else
            return null;

        int identifierSize = 0; // total length of Object Identifier section
        if (reader.readByte() == 0x30)
            identifierSize = readASNLength(reader);
        else
            return null;

        if (reader.readByte() == 0x06) { // is the next element an object identifier?
            int oidLength = readASNLength(reader);
            byte[] oidBytes = new byte[oidLength];
            reader.read(oidBytes, 0, oidBytes.length);
            if (!Arrays.equals(oidBytes, SeqOID)) // is the object identifier rsaEncryption PKCS#1?
                return null;

            int remainingBytes = identifierSize - 2 - oidBytes.length;
            reader.readBytes(remainingBytes);
        }

        if (reader.readByte() == 0x03) { // is the next element a bit string?
            readASNLength(reader); // skip the size
            reader.readByte(); // skip unused bits indicator
            if (reader.readByte() == 0x30) {
                readASNLength(reader); // skip the size
                if (reader.readByte() == 0x02) { // is it an integer?
                    int modulusSize = readASNLength(reader);
                    byte[] modulus = new byte[modulusSize];
                    reader.read(modulus, 0, modulus.length);
                    if (modulus[0] == 0x00) { // strip off the first byte if it's 0
                        byte[] tempModulus = new byte[modulus.length - 1];
                        System.arraycopy(modulus, 1, tempModulus, 0, modulus.length - 1);
                        modulus = tempModulus;
                    }

                    if (reader.readByte() == 0x02) { // is it an integer?
                        int exponentSize = readASNLength(reader);
                        byte[] exponent = new byte[exponentSize];
                        reader.read(exponent, 0, exponent.length);

                        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                        RSAPublicKeySpec keySpec = new RSAPublicKeySpec(new BigInteger(1, modulus), new BigInteger(1, exponent));
                        return keyFactory.generatePublic(keySpec);
                    }
                }
            }
        }
        return null;
    }

    public static int readASNLength(BinaryReader reader) throws IOException {
        // Note: this method only reads lengths up to 4 bytes long as
        // this is satisfactory for the majority of situations.
        int length = reader.readByte();
        if ((length & 0x00000080) == 0x00000080) { // is the length greater than 1 byte
            int count = length & 0x0000000f;
            byte[] lengthBytes = new byte[4];
            reader.read(lengthBytes, 4 - count, count);
            for (int i = 0; i < lengthBytes.length / 2; i++) {
                byte temp = lengthBytes[i];
                lengthBytes[i] = lengthBytes[lengthBytes.length - 1 - i];
                lengthBytes[lengthBytes.length - 1 - i] = temp