import java.io.FileInputStream;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;

public class JarSignatureChecker {
    public void printSignature(String jarFilePath) {
        try (FileInputStream fis = new FileInputStream(jarFilePath);
             JarInputStream jis = new JarInputStream(fis)) {

            Manifest manifest = jis.getManifest();

            if (manifest != null && !manifest.getMainAttributes().containsKey("Signature-Version")) {
                throw new SecurityException("JAR is not signed.");
            }

            Attributes mainAttrs = manifest.getMainAttributes();
            String signatureAlgorithm = mainAttrs.getValue(Attributes.Name.SIGNATURE_VERSION);

            System.out.println("Signature Algorithm: " + signatureAlgorithm);

        } catch (IOException | SecurityException e) {
            e.printStackTrace(); // Handle exception
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Please provide the JAR file path.");
            System.exit(1);
        }

        JarSignatureChecker checker = new JarSignatureChecker();
        checker.printSignature(args[0]);
    }
}