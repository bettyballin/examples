public class Temp61 {
    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "/home/gene/mycacerts");
        System.out.println("TrustStore set to: " + System.getProperty("javax.net.ssl.trustStore"));
    }
}