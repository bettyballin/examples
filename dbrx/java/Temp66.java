import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader {
    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    public static void main(String[] args) {
        try {
            URL[] classLoaderUrls = new URL[]{new URL("file:///path/to/uploaded/classes/")};
            MyClassLoader myLoader = new MyClassLoader(classLoaderUrls);
            Class<?> clazz = myLoader.loadClass("com.example.UserUploadedClass");
            // Do something with the loaded class
        } catch (ClassNotFoundException e) {
            // Handle exception here
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // Handle exception here
            e.printStackTrace();
        }
    }
}