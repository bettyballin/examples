import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

    private final String path;

    public MyClassLoader(ClassLoader parent, String path) {
        super(parent);
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] b = loadClassData(name);
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassData(String name) throws ClassNotFoundException {
        try {
            String filePath = path + name.replace('.', '/') + ".class";
            return Files.readAllBytes(Paths.get(filePath));
        } catch (IOException e) {
            throw new ClassNotFoundException("Class not found", e);
        }
    }

    public static void main(String[] args) {
        try {
            MyClassLoader myClassLoader = new MyClassLoader(ClassLoader.getSystemClassLoader(), "path/to/classes/");
            Class<?> myClass = myClassLoader.loadClass("MyClass");
            System.out.println("Class " + myClass.getName() + " loaded successfully.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}