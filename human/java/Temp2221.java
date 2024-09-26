import java.net.URL;
import java.net.URLClassLoader;

public class ClasspathClassLoader extends URLClassLoader {
    public ClasspathClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.startsWith("com.example.trusted")) {
            return super.loadClass(name);
        } else {
            throw new ClassNotFoundException("Untrusted class: " + name);
        }
    }

    public static void main(String[] args) throws Exception {
        URL[] urls = {
            new URL("file:/path/to/trusted.jar"),
            new URL("file:/path/to/untrusted.jar")
        };
        ClasspathClassLoader loader = new ClasspathClassLoader(urls, ClasspathClassLoader.class.getClassLoader());
        Thread.currentThread().setContextClassLoader(loader);
        Class<?> mainClass = loader.loadClass("com.example.trusted.Main");
        mainClass.getMethod("main", String[].class).invoke(null, (Object) args);
    }
}

// Main class in com.example.trusted
package com.example.trusted;

public class Main {
    public static void main(String[] args) {
        System.out.println("Trusted Main executed!");
    }
}