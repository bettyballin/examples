import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.salt.FixedSaltGenerator;

public class ReproducibleDecryption {
    public static void main(String[] args) {
        BasicTextEncryptor bte = new BasicTextEncryptor();
        // Set a fixed salt (e.g "mysalt")
        String salt = "mysalt";
        FixedSaltGenerator saltGenerator = new FixedSaltGenerator();
        saltGenerator.setSalt(salt.getBytes());
        bte.setSaltGenerator(saltGenerator);
        bte.setPassword("something");  // the seed
        System.out.println(bte.decrypt("Zx5RdBLxIB1sPxG7Os3/6Q=="));  // prints: "mypasswordtext"
    }
}