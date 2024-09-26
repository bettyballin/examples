import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

public class RootClassLoader extends URLClassLoader {
    private List<String> libs = new ArrayList<>();

    public RootClassLoader(URL[] urls) {
        super(urls);
    }

    public void addURL(URL url) {
        super.addURL(url);
        System.out.println("Added URL: " + url);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading class: " + name);
        return super.loadClass(name);
    }

    public void loadLibrary(String libName) {
        try {
            URL url = new File("C:\\Program Files\\Java\\jre7\\lib\\" + libName).toURI().toURL();
            addURL(url);
        } catch (MalformedURLException e) {
            System.out.println("Error loading library: " + libName);
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage
            URL[] urls = new URL[]{};
            RootClassLoader loader = new RootClassLoader(urls);
            loader.loadLibrary("example.jar");
            loader.loadClass("com.example.ClassName");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}