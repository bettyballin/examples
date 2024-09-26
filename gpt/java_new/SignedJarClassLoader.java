import java.io.IOException;
import java.security.CodeSource;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class SignedJarClassLoader extends ClassLoader {
    private final String jarFilePath;

    public SignedJarClassLoader(String jarFilePath) {
        this.jarFilePath = jarFilePath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try (JarFile jarFile = new JarFile(jarFilePath)) {
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                if (entry.getName().endsWith(".class")) {
                    String className = entry.getName().replace('/', '.').replace(".class", "");
                    if (className.equals(name)) {
                        byte[] classBytes = jarFile.getInputStream(entry).readAllBytes();
                        CodeSource cs = new CodeSource(null, (Certificate[]) null);
                        return defineClass(name, classBytes, 0, classBytes.length, cs);
                    }
                }
            }
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load " + name, e);
        }
        return super.findClass(name);
    }
}