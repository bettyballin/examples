import java.io.*;
import java.net.*;
import java.security.*;

public class ByteArrayClassLoader extends ClassLoader {
    private byte[] classData;

    public ByteArrayClassLoader(byte[] classData) {
        this.classData = classData;
    }

    @Override
    protected synchronized Class<?> defineClass(String name, byte[] b, int off, int len) {
        return super.defineClass(name, b, off, len);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> cls = findLoadedClass(name);
        if (cls == null) {
            cls = super.loadClass(name, resolve);
        }
        return cls;
    }

    @Override
    protected URL getResource(String name) {
        // Return a URL that represents the byte array
        try {
            return new MemoryURL(name, classData);
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private static class MemoryURL extends URL {
        private final byte[] data;
        private final String name;

        public MemoryURL(String name, byte[] data) throws MalformedURLException {
            super("memory", null, -1, "/" + name, new MemoryURLStreamHandler(data));
            this.data = data;
            this.name = name;
        }
    }

    private static class MemoryURLStreamHandler extends URLStreamHandler {
        private final byte[] data;

        public MemoryURLStreamHandler(byte[] data) {
            this.data = data;
        }

        @Override
        protected URLConnection openConnection(URL u) {
            return new MemoryURLConnection(u, data);
        }
    }

    private static class MemoryURLConnection extends URLConnection {
        private final byte[] data;

        protected MemoryURLConnection(URL url, byte[] data) {
            super(url);
            this.data = data;
        }

        @Override
        public void connect() throws IOException {
            // No need to implement
        }

        @Override
        public InputStream getInputStream() throws IOException {
            return new ByteArrayInputStream(data);
        }
    }

    public static void main(String[] args) throws Exception {
        // Example usage:
        byte[] classData = { /* class file data */ };
        ByteArrayClassLoader loader = new ByteArrayClassLoader(classData);
        Class<?> cls = loader.loadClass("ExampleClass");
        System.out.println(cls.getName());
    }
}