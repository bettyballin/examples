public class KeystoreFinder {
    public static void main(String[] args) {
        String keystorePath = System.getProperty("javax.net.ssl.keyStore");
        String keystorePassword = System.getProperty("javax.net.ssl.keyStorePassword");
        String truststorePath = System.getProperty("javax.net.ssl.trustStore");
        String truststorePassword = System.getProperty("javax.net.ssl.trustStorePassword");

        System.out.println("Keystore path: " + keystorePath);
        System.out.println("Keystore password: " + (keystorePassword != null ? "****" : "null"));
        System.out.println("Truststore path: " + truststorePath);
        System.out.println("Truststore password: " + (truststorePassword != null ? "****" : "null"));
    }
}