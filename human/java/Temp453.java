public class Temp453 {
    public static void main(String[] args) {
        String data = "For my current project I have to send a signature from PHP to Java application. I am using Crypt/RSA right now for signing my data.";

        String privateKeyPEM = "-----BEGIN RSA PRIVATE KEY-----\n"
                + "MIIBOgIBAAJBANDiE2+Xi/WnO+s120NiiJhNyIButVu6zxqlVzz0wy2j4kQVUC4Z\n"
                + "RZD80IY+4wIiX2YxKBZKGnd2TtPkcJ/ljkUCAwEAAQJAL151ZeMKHEU2c1qdRKS9\n"
                + "sTxCcc2pVwoAGVzRccNX16tfmCf8FjxuM3WmLdsPxYoHrwb1LFNxiNk1MXrxjH3R\n"
                + "6QIhAPB7edmcjH4bhMaJBztcbNE1VRCEi/bisAwiPPMq9/2nAiEA3lyc5+f6DEIJ\n"
                + "h1y6BWkdVULDSM+jpi1XiV/DevxuijMCIQCAEPGqHsF+4v7Jj+3HAgh9PU6otj2n\n"
                + "Y79nJtCYmvhoHwIgNDePaS4inApN7omp7WdXyhPZhBmulnGDYvEoGJN66d0CIHra\n"
                + "I2SvDkQ5CmrzkW5qPaE2oO7BSqAhRZxiYpZFb5CI\n"
                + "-----END RSA PRIVATE KEY-----";

        try {
            java.security.Security.addProvider(
                new org.bouncycastle.jce.provider.BouncyCastleProvider()
            );

            String privateKeyPEMFormatted = privateKeyPEM.replace("-----BEGIN RSA PRIVATE KEY-----", "")
                    .replace("-----END RSA PRIVATE KEY-----", "")
                    .replaceAll("\\s", "");

            byte[] keyBytes = java.util.Base64.getDecoder().decode(privateKeyPEMFormatted);

            java.security.spec.PKCS8EncodedKeySpec spec = new java.security.spec.PKCS8EncodedKeySpec(keyBytes);
            java.security.KeyFactory keyFactory = java.security.KeyFactory.getInstance("RSA");
            java.security.PrivateKey privateKey = keyFactory.generatePrivate(spec);

            java.security.Signature signature = java.security.Signature.getInstance("SHA256withRSA");
            signature.initSign(privateKey);
            signature.update(data.getBytes(java.nio.charset.StandardCharsets.UTF_8));

            byte[] signedData = signature.sign();

            System.out.println(java.util.Base64.getEncoder().encodeToString(signedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


To execute the above Java code, ensure that you have the Bouncy Castle library in your classpath. You can download it from https://www.bouncycastle.org/latest_releases.html and add it to your project.