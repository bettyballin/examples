import org.bouncycastle.crypto.AsymmetricKeyParameter;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import org.bouncycastle.operator.bc.BcRSAContentSignerBuilder;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

import java.io.OutputStream;

public class CustomSignature {

    private static class CustomNullDigest implements Digest {
        private final byte[] output = new byte[0];

        @Override
        public String getAlgorithmName() {
            return "NONE";
        }

        @Override
        public int getDigestSize() {
            return output.length;
        }

        @Override
        public void update(byte in) {
        }

        @Override
        public void update(byte[] in, int inOff, int len) {
        }

        @Override
        public int doFinal(byte[] out, int outOff) throws DataLengthException, IllegalStateException {
            System.arraycopy(output, 0, out, outOff, output.length);
            return output.length;
        }

        @Override
        public void reset() {
        }
    }

    private byte[] computeSignature(byte[] message, AsymmetricKeyParameter privateKey) throws Exception {
        AlgorithmIdentifier sigAlgId = new DefaultSignatureAlgorithmIdentifierFinder().find("NONEwithRSA");

        ContentSigner signer = new BcRSAContentSignerBuilder(sigAlgId, new CustomNullDigest()).build(privateKey);

        try (OutputStream outputStream = signer.getOutputStream()) {
            outputStream.write(message);
            return signer.getSignature();
        }
    }

    public static void main(String[] args) {
        // Example usage
        // AsymmetricKeyParameter privateKey = ... // Initialize private key
        // byte[] message = "Hello, World!".getBytes();
        // byte[] signature = new CustomSignature().computeSignature(message, privateKey);
        // System.out.println(java.util.Base64.getEncoder().encodeToString(signature));
    }
}