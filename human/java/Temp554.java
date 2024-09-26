import java.security.MessageDigest;
import java.security.cert.Certificate;

public class Temp554 {
    public static void main(String[] args) {
        // Example usage
        try {
            // In a real scenario, you would obtain a Certificate instance
            Certificate cert = null; // Placeholder for actual certificate
            Temp554 temp = new Temp554();
            String fingerPrint = temp.getCertFingerPrint("SHA-256", cert);
            System.out.println("Certificate Fingerprint: " + fingerPrint);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Gets the requested finger print of the certificate.
     */
    private String getCertFingerPrint(String mdAlg, Certificate cert) throws Exception {
        if (cert == null) {
            throw new IllegalArgumentException("Certificate cannot be null");
        }
        byte[] encCertInfo = cert.getEncoded();
        MessageDigest md = MessageDigest.getInstance(mdAlg);
        byte[] digest = md.digest(encCertInfo);
        return toHexString(digest);
    }

    private String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}