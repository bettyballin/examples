package com.example.trusted;

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
                if (!classpathEntry.endsWith(".jar") && !classpathEntry.endsWith("/")) {
                    // URLClassLoader assumes paths without a trailing '/' to be JARs by default
                    classpathEntry += "/";
                }
                addURL(new URL("file:" + classpathEntry));
            } catch (MalformedURLException mue) {
                System.err.println(MessageFormat.format("Erroneous class path entry [{0}] skipped.", classpathEntry));
            }
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> ret;
        synchronized (getClassLoadingLock(name)) {
            ret = findLoadedClass(name);
            if (ret != null) {
                return ret;
            }
            if (SYSTEM_CLASS_PREFIX.matcher(name).matches()) {
                return super.loadClass(name, resolve);
            }
            ret = findClass(name);
            if (resolve) {
                resolveClass(ret);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        ClasspathClassLoader loader = new ClasspathClassLoader(ClassLoader.getSystemClassLoader());
        Class<?> clazz = loader.loadClass("java.lang.String");
        System.out.println("Loaded class: " + clazz.getName());
    }
}