import java.lang.reflect.*;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreSpi;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;

public class Main {

    private KeyStore keystore1;

    public Main(KeyStore keystore) {
        this.keystore1 = keystore;
    }

    public void printKeystore() throws Exception {
        Field spiField = KeyStore.class.getDeclaredField("keyStoreSpi");
        spiField.setAccessible(true);
        KeyStoreSpi spi = (KeyStoreSpi) spiField.get(keystore1);
        Field entriesField = spi.getClass().getSuperclass().getDeclaredField("entries");
        entriesField.setAccessible(true);
        Collection entries = (Collection) entriesField.get(spi);
        for (Object entry : entries) {
            String alias = (String) invokeGetter(entry, "getAlias");
            Key privateKey = (Key) invokeGetter(entry, "getPrivateKey");
            X509Certificate[] certificateChain = (X509Certificate[]) invokeGetter(entry, "getCertificateChain");
            System.out.println(alias + ": " + privateKey + Arrays.toString(certificateChain));
        }
    }

    private Object invokeGetter(Object instance, String methodName)
            throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException {
        Method getAlias = instance.getClass().getDeclaredMethod(methodName);
        getAlias.setAccessible(true);
        return getAlias.invoke(instance);
    }

    public static void main(String[] args) throws Exception {
        // Assuming keystore is already loaded
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(null, null); // Load with your keystore data
        Main main = new Main(keystore);
        main.printKeystore();
    }
}