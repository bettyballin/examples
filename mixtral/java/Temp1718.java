import java.math.BigInteger;
import java.security.SignatureException;

import org.bouncycastle.crypto.signers.ECDSASigner;

public class Temp1718 {

    private ECDSASigner signer;

    public static void main(String[] args) {
        Temp1718 temp = new Temp1718();
        try {
            byte[] signedData = temp.sign("Hello, World!".getBytes());
            System.out.println("Signature: " + new String(signedData));
        } catch (SignatureException e) {
            e.printStackTrace();
        }
    }

    public byte[] sign(byte[] bytes) throws SignatureException {
        try {
            signer.update(bytes, 0, bytes.length);

            // Generate the signature
            BigInteger[] signature = signer.generateSignature();

            BigInteger r = signature[0];
            BigInteger s = signature[1];

            // Encode them with consistent length
            byte[] signatureBytes = encodeSignature(r.toByteArray(), s.toByteArray());

            return signatureBytes;
        } catch (Exception e) {
            throw new SignatureException("Error during signing", e);
        }
    }

    private byte[] encodeSignature(byte[] r, byte[] s) {
        // Assuming a fixed length of 32 bytes for each component
        byte[] signature = new byte[64];
        System.arraycopy(r, 0, signature, 0, r.length);
        System.arraycopy(s, 0, signature, 32, s.length);
        return signature;
    }
}