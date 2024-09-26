import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;

public class JarSignerDemo {
    public static void main(String[] args) {
        try {
            // Load keystore
            FileInputStream is = new FileInputStream("keystore.jks");
            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(is, "keystorepassword".toCharArray());

            // Get private key
            KeyStore.PrivateKeyEntry pkEntry = (KeyStore.PrivateKeyEntry) keystore.getEntry("alias",
                    new KeyStore.PasswordProtection("keypassword".toCharArray()));
            PrivateKey myPrivateKey = pkEntry.getPrivateKey();

            // Get certificate
            Certificate[] chain = keystore.getCertificateChain("alias");

            // Create a signature object
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initSign(myPrivateKey);

            // Create a manifest
            Manifest manifest = new Manifest();
            manifest.getMainAttributes().putValue("Manifest-Version", "1.0");

            // Create a JAR file
            FileOutputStream fos = new FileOutputStream("output.jar");
            JarOutputStream jos = new JarOutputStream(fos, manifest);

            // Add entries to JAR file
            File file = new File("fileToInclude.txt");
            JarEntry entry = new JarEntry(file.getName());
            jos.putNextEntry(entry);

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                jos.write(buffer, 0, bytesRead);
                signature.update(buffer, 0, bytesRead);
            }
            fis.close();

            // Close JAR entry
            jos.closeEntry();

            // Get the signature
            byte[] digitalSignature = signature.sign();

            // Close JAR output stream
            jos.close();

            // Save the signature (for demonstration)
            FileOutputStream sigfos = new FileOutputStream("signature.sig");
            sigfos.write(digitalSignature);
            sigfos.close();

            System.out.println("JAR file signed successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}