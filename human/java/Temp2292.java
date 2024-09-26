public class Temp2292 {
    public static void main(String[] args) {
        System.setProperty("org.apache.ws.security.crypto.provider", "org.apache.ws.security.components.crypto.Merlin");
        System.setProperty("org.apache.ws.security.crypto.merlin.keystore.type", "jks");
        System.setProperty("org.apache.ws.security.crypto.merlin.keystore.password", "mypass");
        System.setProperty("org.apache.ws.security.crypto.merlin.keystore.alias", "myalias");
        System.setProperty("org.apache.ws.security.crypto.merlin.keystore.file", "C:\\Program Files\\Java\\jdk1.8.0_131\\jre\\lib\\security\\file.jks");

        // These properties are now set and can be used by the application
        System.out.println("Properties set successfully.");
    }
}