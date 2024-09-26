import java.security.*;
import java.security.spec.*;

import javax.crypto.*;
import javax.crypto.spec.*;

public class CustomRSAPSSSignature extends SignatureSpi {
    private static final String ALGORITHM = "SHA256withRSA/PSS";
    private PSSParameterSpec pssParams;
    private Signature signature;

    @Override
    protected void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        // Set your desired parameters here
        this.pssParams = new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);

        try {
            signature = Signature.getInstance(ALGORITHM);
            signature.initSign(privateKey);
            
            // Set the parameters on the underlying implementation
            signature.setParameter(pssParams);
        } catch (Exception e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override
    protected void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        // Set your desired parameters here
        this.pssParams = new PSSParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);

        try {
            signature = Signature.getInstance(ALGORITHM);
            signature.initVerify(publicKey);
            
            // Set the parameters on the underlying implementation
            signature.setParameter(pssParams);
        } catch (Exception e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override
    protected void engineUpdate(byte b) throws SignatureException {
        signature.update(b);
    }

    @Override
    protected void engineUpdate(byte[] b, int off, int len) throws SignatureException {
        signature.update(b, off, len);
    }

    @Override
    protected byte[] engineSign() throws SignatureException {
        return signature.sign();
    }

    @Override
    protected boolean engineVerify(byte[] sigBytes) throws SignatureException {
        return signature.verify(sigBytes);
    }

    @Override
    protected void engineSetParameter(String param, Object value) throws InvalidParameterException {
        throw new InvalidParameterException("Method not implemented");
    }

    @Override
    protected void engineSetParameter(AlgorithmParameterSpec params) throws InvalidAlgorithmParameterException {
        if (params instanceof PSSParameterSpec) {
            this.pssParams = (PSSParameterSpec) params;
            try {
                signature.setParameter(pssParams);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException(e.getMessage());
            }
        } else {
            throw new InvalidAlgorithmParameterException("Unsupported parameter spec");
        }
    }

    @Override
    protected AlgorithmParameters engineGetParameter() throws InvalidAlgorithmParameterException {
        try {
            AlgorithmParameters params = AlgorithmParameters.getInstance("PSS");
            params.init(pssParams);
            return params;
        } catch (Exception e) {
            throw new InvalidAlgorithmParameterException(e.getMessage());
        }
    }
}