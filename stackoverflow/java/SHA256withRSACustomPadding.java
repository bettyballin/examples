import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import org.bouncycastle.crypto.engines.RSABlindedEngine;
import org.bouncycastle.crypto.signers.PSSSigner;

public class SHA256withRSACustomPadding {
    private PSSSigner signer;

    public SHA256withRSACustomPadding(int padding) {
        signer = new PSSSigner(new RSABlindedEngine(), new SHA256Digest(), new SHA256Digest(), padding);
    }

    public void initSign(PrivateKey privateKey) throws InvalidKeyException {
        CipherParameters param = RSAUtil.generatePrivateKeyParameter(privateKey);
        signer.init(true, param);
    }

    public void update(byte[] data) throws SignatureException {
        signer.update(data, 0, data.length);
    }

    public byte[] sign() throws SignatureException {
        try {
            return signer.generateSignature();
        } catch (CryptoException e) {
            throw new SignatureException(e.getMessage(), e);
        }
    }

    public void initVerify(PublicKey publicKey) throws InvalidKeyException {
        CipherParameters param = RSAUtil.generatePublicKeyParameter(publicKey);
        signer.init(false, param);
    }

    public boolean verify(byte[] signature) throws SignatureException {
        return signer.verifySignature(signature);
    }
}