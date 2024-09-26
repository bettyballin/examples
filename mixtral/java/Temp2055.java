import android.util.Log;

public class KeyProtectionChecker {

    private static final String TAG = "KeyProtectionChecker";

    public static void main(String[] args) {
        System.out.println("Has Key Protection: " + hasKeyProtection());
    }

    private static boolean hasKeyProtection() {
        try {
            Class.forName("android.security.keystore.KeyGenParameterSpec$Builder");
            return true;
        } catch (ClassNotFoundException e) {
            // Key protection is not available
            Log.w(TAG, "Failed to load class: android.security.keystore.KeyProtection", e);
            return false;
        }
    }
}