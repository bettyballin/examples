import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Manifest manifest = new Manifest();
        Attributes attributes = manifest.getMainAttributes();
        attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        attributes.put(new Attributes.Name("Application-Name"), "Our App Name");
        attributes.put(new Attributes.Name("Main-Class"), "com.whatever.main.AppLoader");
        attributes.put(new Attributes.Name("Class-Path"), "./Corejar.jar ./Support.jar");
        attributes.put(new Attributes.Name("Built-By"), System.getProperty("user.name"));
        attributes.put(new Attributes.Name("Permissions"), "all-permissions");
        attributes.put(new Attributes.Name("Codebase"), "*");
        attributes.put(new Attributes.Name("Application-Library-Allowable-Codebase"), "*");
        attributes.put(new Attributes.Name("Trusted-Only"), "true");
        attributes.put(new Attributes.Name("Specification-Title"), "Our App Name");
        attributes.put(new Attributes.Name("Specification-Version"), System.getProperty("version", "1.0"));
        attributes.put(new Attributes.Name("Specification-Vendor"), "Our Company Name");

        try (FileOutputStream fos = new FileOutputStream("META-INF/MANIFEST.MF")) {
            manifest.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}