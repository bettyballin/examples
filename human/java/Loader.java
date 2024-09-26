package com.technojeeves.shm;

import java.util.Base64;
import java.util.zip.*;
import java.util.*;
import java.io.*;
import java.lang.reflect.Method;

public class Loader {
    public static void main(String[] args) {
         final String JARENC = "UEsDBBQACAgIABqp8FIAAAAAAAAAAAAAAAAlAAQAY29tL3RlY2hub2plZXZlcy9zaG0vSGVsbG9Xb3JsZC5jbGFzc/7KAABtUMtOwkAUPZdXaa2CIPgkwsIEXNiNO4wbE+OCqAkGF65KmcCQtmPKgPGzdKGJCz/AjzLeaUzQhFncx5nzSO7X98cngFM0HGSQtZBzkUeBUJ76C98L/Xjs3QynItCEwpmMpT4nZNudgY0ibAuOizW4/+j955kWEbPUnEW1XvojlXebyFj3dSL8qFvEBsG9EmGomk8qCUctB2VsWqi4qGKLUF2hIliPZgtjtm33/iRqhsfdzsBCnXAYqMjTIpjEairEQsy82STy0qx7E0XIXaiRIJR6MhbX82gokjt/GDKSi3zJ5vX2wyp3gtNX8yQQl9KQS0vLE8NGCzW+oXkZkLki123eGtyJe/74HfTCA2GHayEFs7Cxi71f6lEqBexXWJX1N5SWdCf1zvPZjXA/TTn4AVBLBwhqV5QAMQEAAL8BAABQSwECFAAUAAgICAAaqfBSaleUADEBAAC/AQAAJQAEAAAAAAAAAAAAAAAAAAAAY29tL3RlY2hub2plZXZlcy9zaG0vSGVsbG9Xb3JsZC5jbGFzc/7KAABQSwUGAAAAAAEAAQBXAAAAiAEAAAAA";


        try {
            Base64.Decoder dec = Base64.getDecoder();
            byte[] jarBytes = dec.decode(JARENC);
            RemoteClassLoader memJarLoader = new RemoteClassLoader(jarBytes);
            Class<?> hw = memJarLoader.loadClass("com.technojeeves.shm.HelloWorld", true);
            Method main = hw.getMethod("main", String[].class);
            String[] params = null;
            main.invoke(null, (Object)params);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    static class RemoteClassLoader extends ClassLoader {

        private final byte[] jarBytes;
        private final Set<String> names;

        public RemoteClassLoader(byte[] jarBytes) throws IOException {
            this.jarBytes = jarBytes;
            this.names = RemoteClassLoader.loadNames(jarBytes);
        }

        /**
         * This will put all the entries into a thread-safe Set
         */
        private static Set<String> loadNames(byte[] jarBytes) throws IOException {
            Set<String> set = new HashSet<>();
            try (ZipInputStream jis = new ZipInputStream(new ByteArrayInputStream(jarBytes))) {
                ZipEntry entry;
                while ((entry = jis.getNextEntry()) != null) {
                    set.add(entry.getName());
                }
            }
            return Collections.unmodifiableSet(set);
        }

        @Override
        public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            Class<?> clazz = findLoadedClass(name);
            if (clazz == null) {
                try {
                    String toLoad = name.replace('.', '/') + ".class";
                    //System.out.printf("Attempting to load %s%n", toLoad);
                    InputStream in = getResourceAsStream(name.replace('.', '/') + ".class");
                    ByteArrayOutputStream out = new ByteArrayOutputStream();
                    //StreamUtils.writeTo(in, out);
                    copyStream(in, out);
                    byte[] bytes = out.toByteArray();
                    clazz = defineClass(name, bytes, 0, bytes.length);
                    if (resolve) {
                        resolveClass(clazz);
                    }
                } catch (Exception e) {
                    clazz = super.loadClass(name, resolve);
                }
            }
            return clazz;
        }

        @Override
        public InputStream getResourceAsStream(String name) {
            // Check first if the entry name is known
            if (!names.contains(name)) {
                return null;
            }
            //