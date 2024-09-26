import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.UUID;

public class SecurePreferencesHelper {
    public static SharedPreferences getEncryptedSharedPreferences(Context context) {
        String uniqueID = UUID.randomUUID().toString();
        MasterKey masterKey;
        SharedPreferences sharedPreferences = null;
        try {
            masterKey = new MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build();
            
            sharedPreferences = EncryptedSharedPreferences.create(
                context,
                "my_secure_preferences_filename",
                masterKey, // MasterKey created using the Android Keystore
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
            );
        } catch (GeneralSecurityException | IOException e) {
            // Handle the exception
        }
        return sharedPreferences;
    }
}