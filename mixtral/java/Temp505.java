public class Temp505 {
    public static void main(String[] args) {

        System.setProperty("javax.net.ssl.keyStoreType", "pkcs12");
        System.setProperty("javax.net.ssl.keyStorePassword", "<your_keystore_password>");
        System.setProperty("javax.net.ssl.keyStore", "/path/to/keystorefile");

    }
}