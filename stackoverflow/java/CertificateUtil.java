import java.security.MessageDigest;
import java.security.cert.Certificate;

public class CertificateUtil {

    /**
     * Gets the requested finger print of the certificate.
     *
     * @param mdAlg algorithm for message digest
     * @param cert the certificate to get the fingerprint of
     * @return the fingerprint as a String
     * @throws Exception if an encoding error occurs or the algorithm is not found
     */
    private String getCertFingerPrint(String mdAlg, Certificate cert) throws Exception {
        byte[] encCertInfo = cert.getEncoded();
        MessageDigest md = MessageDigest.getInstance(mdAlg);
        byte[] digest = md.digest(encCertInfo);
        return toHexString(digest);
    }

    /**
     * Converts a byte array to a hex string.
     *
     * @param bytes the byte array to convert
     * @return the hex string representation of the bytes
     */
    private String toHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}