import org.jasypt.util.text.BasicTextEncryptor;

public class ReproducibleEncryption {
    public static void main(String[] args) {
        BasicTextEncryptor bte = new BasicTextEncryptor();
        // Set a fixed password (salt is handled internally by Jasypt)
        bte.setPassword("mysalt");
        String ep = bte.encrypt("mypasswordtext");
        System.out.println(ep);  // prints encrypted text
    }
}