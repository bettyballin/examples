import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreSpi;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;

public class KeystorePrinter {

    public void printKeystore(KeyStore keystore) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field spiField = KeyStore.class.getDeclaredField("keyStoreSpi");
        spiField.setAccessible(true);
        KeyStoreSpi spi = (KeyStoreSpi) spiField.get(keystore);
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
        Method getter = instance.getClass().getDeclaredMethod(methodName);
        getter.setAccessible(true);
        return getter.invoke(instance);
    }
}