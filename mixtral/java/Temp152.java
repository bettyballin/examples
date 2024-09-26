import java.io.*;
import java.util.jar.*;

public class Temp152 {
    public static void main(String[] args) {
        Temp152 temp = new Temp152();
        String jarFilePath = "path/to/your/jarfile.jar";
        boolean isSigned = temp.isJarSigned(jarFilePath);
        System.out.println("Is the JAR signed? " + isSigned);
    }

    public boolean isJarSigned(String jarFilePath) {
        try (FileInputStream fis = new FileInputStream(jarFilePath)) {
            JarInputStream jis = new JarInputStream(fis);

            Manifest manifest = jis.getManifest();

            if (manifest != null && !manifest.getMainAttributes().containsKey("Signature-Version"))
                return false;

        } catch (IOException | SecurityException e) {
            // Handle exception
            e.printStackTrace();
        }

        return true;
    }
}