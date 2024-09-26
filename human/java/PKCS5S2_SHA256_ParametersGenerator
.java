import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.PBEParametersGenerator;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PKCS5S2_SHA256_ParametersGenerator extends PBEParametersGenerator {

    private Mac hMac = new HMac(new SHA256Digest());

    public PKCS5S2_SHA256_ParametersGenerator() {
    }

    private void F(byte[] P, byte[] S, int c, byte[] iBuf, byte[] out, int outOff) {
        byte[] state = new byte[hMac.getMacSize()];
        CipherParameters param = new KeyParameter(P);

        hMac.init(param);

        if (S != null) {
            hMac.update(S, 0, S.length);
        }

        hMac.update(iBuf, 0, iBuf.length);

        hMac.doFinal(state, 0);

        System.arraycopy(state, 0, out, outOff, state.length);

        if (c == 0) {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }

        for (int count = 1; count < c; count++) {
            hMac.init(param);
            hMac.update(state, 0, state.length);
            hMac.doFinal(state, 0);

            for (int j = 0; j != state.length; j++) {
                out[outOff + j] ^= state[j];
            }
        }
    }

    private void intToOctet(byte[] buf, int i) {
        buf[0] = (byte) (i >>> 24);
        buf[1] = (byte) (i >>> 16);
        buf[2] = (byte) (i >>> 8);
        buf[3] = (byte) i;
    }

    private byte[] generateDerivedKey(int dkLen) {
        int hLen = hMac.getMacSize();
        int l = (dkLen + hLen - 1) / hLen;
        byte[] iBuf = new byte[4];
        byte[] out = new byte[l * hLen];

        for (int i = 1; i <= l; i++) {
            intToOctet(iBuf, i);
            F(password, salt, iterationCount, iBuf, out, (i - 1) * hLen);
        }

        return out;
    }

    public CipherParameters generateDerivedParameters(int keySize) {
        keySize = keySize / 8;
        byte[] dKey = generateDerivedKey(keySize);
        return new KeyParameter(dKey, 0, keySize);
    }

    public CipherParameters generateDerivedParameters(int keySize, int ivSize) {
        keySize = keySize / 8;
        ivSize = ivSize / 8;
        byte[] dKey = generateDerivedKey(keySize + ivSize);
        return new ParametersWithIV(new KeyParameter(dKey, 0, keySize), dKey, keySize, ivSize);
    }

    public CipherParameters generateDerivedMacParameters(int keySize) {
        return generateDerivedParameters(keySize);
    }

    public static void main(String[] args) {
        // Example usage:
        PKCS5S2_SHA256_ParametersGenerator generator = new PKCS5S2_SHA256_ParametersGenerator();
        generator.init("password".getBytes(), "salt".getBytes(), 1000);
        CipherParameters params = generator.generateDerivedParameters(256);
        System.out.println("Derived Key: " + ((KeyParameter) params).getKey().length);
    }
}


To run this code, you need to include the Bouncy Castle library in your project. If you are using Maven, add the following dependency to your `pom.xml` file:

xml
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk15on</artifactId>
    <version>1.70</version>
</dependency>