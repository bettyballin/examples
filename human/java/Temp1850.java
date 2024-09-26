import io.realm.Realm;
import io.realm.RealmConfiguration;
import java.security.SecureRandom;
import android.content.Context;

public class Temp1850 {

    public static void main(String[] args) {
        // Assuming context is provided somehow in an Android environment
        Context context = getContext();

        byte[] key = new byte[64];
        new SecureRandom().nextBytes(key);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .encryptionKey(key)
                .build();

        Realm realm = Realm.getInstance(config);
    }

    private static Context getContext() {
        // Dummy method to simulate obtaining a Context in a non-Android environment
        return null;
    }
}