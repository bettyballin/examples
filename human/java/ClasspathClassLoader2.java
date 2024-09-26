package com.example.trusted;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.ByteBuffer;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public final class ClasspathClassLoader extends URLClassLoader {

    private static final Pattern SYSTEM_CLASS_PREFIX = Pattern.compile("((java(x)?|sun|oracle)\\.).*");
    private static final List<WeakReference<ProtectionDomain>> DOMAIN_CACHE = new ArrayList<>();

    public ClasspathClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        URL classOrigin = getClassResource(name);
        if (classOrigin == null) {
            return super.findClass(name);
        }
        URL classCodeSourceOrigin = getClassCodeSourceResource(classOrigin);
        if (classCodeSourceOrigin == null) {
            return super.findClass(name);
        }
        return defineClass(name, readClassData(classOrigin), constructClassDomain(classCodeSourceOrigin));
    }

    private URL getClassResource(String name) {
        return AccessController.doPrivileged((PrivilegedAction<URL>) () -> getResource(name.replace(".", "/") + ".class"));
    }

    private URL getClassCodeSourceResource(URL classResource) {
        for (URL classpathEntry : getURLs()) {
            if (classResource.getPath().startsWith(classpathEntry.getPath())) {
                return classpathEntry;
            }
        }
        return null;
    }

    private ByteBuffer readClassData(URL classResource) {
        try (BufferedInputStream in = new BufferedInputStream(classResource.openStream());
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            int i;
            while ((i = in.read()) != -1) {
                out.write(i);
            }
            return ByteBuffer.wrap(out.toByteArray());
        } catch (IOException ioe) {
            throw new RuntimeException(ioe);
        }
    }

    private ProtectionDomain constructClassDomain(URL classCodeSourceResource) {
        ProtectionDomain ret = getCachedDomain(classCodeSourceResource);
        if (ret == null) {
            CodeSource cs = new CodeSource(classCodeSourceResource, (Certificate[]) null);
            ret = new ProtectionDomain(cs, null, this, null);
            DOMAIN_CACHE.add(new WeakReference<>(ret));
        }
        return ret;
    }

    private ProtectionDomain getCachedDomain(URL classCodeSourceResource) {
        for (WeakReference<ProtectionDomain> domainRef : DOMAIN_CACHE) {
            ProtectionDomain domain = domainRef.get();
            if (domain == null) {
                DOMAIN_CACHE.remove(domainRef);
            } else if (domain.getCodeSource().implies(new CodeSource(classCodeSourceResource, (Certificate[]) null))) {
                return domain;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        try {
            URL[] urls = {new File("path/to/classes").toURI().toURL()};
            ClasspathClassLoader loader = new ClasspathClassLoader(urls);
            Class<?> clazz = loader.loadClass("com.example.MyClass");
            System.out.println("Class loaded: " + clazz.getName());
        } catch (MalformedURLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}