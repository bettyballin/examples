public class Temp2843 {
    public static void main(String[] args) {
        try {
            throw new javax.net.ssl.SSLHandshakeException(
                new sun.security.validator.ValidatorException(
                    "PKIX path validation failed",
                    new java.security.cert.CertPathValidatorException("timestamp check failed")
                )
            );
        } catch (javax.net.ssl.SSLHandshakeException e) {
            System.out.println("Handling exception: " + e);
        }
    }
}