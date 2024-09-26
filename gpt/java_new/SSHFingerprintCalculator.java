import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.util.Base64;

public class SSHFingerprintCalculator {

    public static String calculateSSHFingerprint(RSAPublicKey rsaPublicKey) throws Exception {
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(byteOs);
        byte[] keyTypeBytes = "ssh-rsa".getBytes("UTF-8");
        byte[] exponentBytes = rsaPublicKey.getPublicExponent().toByteArray();
        byte[] modulusBytes = rsaPublicKey.getModulus().toByteArray();
        if (modulusBytes[0] == 0) {
            byte[] tmp = new byte[modulusBytes.length - 1];
            System.arraycopy(modulusBytes, 1, tmp, 0, tmp.length);
            modulusBytes = tmp;
        }
        
        dos.writeInt(keyTypeBytes.length);
        dos.write(keyTypeBytes);
        dos.writeInt(exponentBytes.length);
        dos.write(exponentBytes);
        dos.writeInt(modulusBytes.length);
        dos.write(modulusBytes);
        
        byte[] publicKeyEncoded = byteOs.toByteArray();
        dos.close();
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(publicKeyEncoded);
        byte[] fingerprintDigest = md.digest();
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fingerprintDigest.length; i++) {
            sb.append(String.format("%02X%s", fingerprintDigest[i], (i < fingerprintDigest.length - 1) ? ":" : ""));
        }
        
        return sb.toString().toLowerCase();
    }
}