import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.MessageFormat;
import java.util.regex.Pattern;

public class ClasspathClassLoader extends URLClassLoader {

    private static final Pattern SYSTEM_CLASS_PREFIX = Pattern.compile("((java(x)?|sun|oracle)\\.).*");

    public ClasspathClassLoader(ClassLoader parent) {
        super(new URL[0], parent);
        String[] classpath = System.getProperty("java.class.path").split(File.pathSeparator);
        for (String classpathEntry : classpath) {
            try {
                if (!classpathEntry.endsWith(".jar")) {
                    classpathEntry += "/";
                }
                addURL(new File(classpathEntry).toURI().toURL());
            } catch (MalformedURLException mue) {
                System.err.println(MessageFormat.format("Erroneous class path entry [{0}] skipped.", classpathEntry));
            }
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        synchronized (getClassLoadingLock(name)) {
            Class<?> c = findLoadedClass(name);
            if (c == null && !SYSTEM_CLASS_PREFIX.matcher(name).matches()) {
                try {
                    c = findClass(name);
                } catch (ClassNotFoundException e) {
                    // Ignore, try parent
                }
            }
            if (c == null) {
                c = super.loadClass(name, resolve);
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
}