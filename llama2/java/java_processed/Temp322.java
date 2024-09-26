import java.security.KeyStore;

public class Temp322 {
    public static void main(String[] args) {
        try {
            KeyStore ks = KeyStore.getInstance("jceks");
            ks.load(null, "password".toCharArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}