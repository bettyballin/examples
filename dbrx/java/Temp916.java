import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

public class Temp916 {
    private static final String TAG = "Temp916";

    public static void main(String[] args) {
        PackageManager pm = getPackageManager();
        ApplicationInfo ai;
        try {
            ai = pm.getApplicationInfo("your.app.package.name", PackageManager.GET_META_DATA);
            Bundle bundle = ai.metaData;
            boolean allowBackup = bundle.getBoolean("android:allowBackup");
            System.out.println("Allow Backup: " + allowBackup);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Unable to find package name.", e);
        }
    }

    // Dummy method to make the code compile
    private static PackageManager getPackageManager() {
        // This would normally return your application's PackageManager
        return null;
    }
}