import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CustomClassLoader extends URLClassLoader {
    private final Set<String> deniedClasses = new HashSet<>(Arrays.asList("java.lang.System"));

    public CustomClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (deniedClasses.contains(name))
            throw new SecurityException("Access to class " + name + " is denied.");

        return super.loadClass(name, resolve);
    }

    public static void main(String[] args) {
        try {
            URL[] urls = {}; // Add URLs as needed
            CustomClassLoader loader = new CustomClassLoader(urls, CustomClassLoader.class.getClassLoader());

            // Example usage
            Class<?> clazz = loader.loadClass("java.lang.String");
            System.out.println("Class loaded: " + clazz.getName());
            
            // This will throw a SecurityException
            loader.loadClass("java.lang.System");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}