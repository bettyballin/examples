import java.io.*;
import java.util.jar.*;

public class UpdateJar {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java UpdateJar <jarfile.jar> <path/to/classfile.class>");
            return;
        }

        String jarFilePath = args[0];
        String classFilePath = args[1];

        try (JarFile jarFile = new JarFile(jarFilePath);
             FileInputStream fis = new FileInputStream(classFilePath);
             FileOutputStream fos = new FileOutputStream(jarFilePath, true);
             JarOutputStream jos = new JarOutputStream(fos)) {

            JarEntry entry = new JarEntry(new File(classFilePath).getName());
            jos.putNextEntry(entry);

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                jos.write(buffer, 0, bytesRead);
            }
            jos.closeEntry();
            System.out.println("Class file added to JAR successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}