public class MyClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        if (name.startsWith("secret.class")) {
            throw new ClassNotFoundException("Access to this class is forbidden");
        }
        return super.loadClass(name, resolve);
    }
}