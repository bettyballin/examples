import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.app.Activity;

public class Temp2192 extends Activity {
    @Override
    protected void onCreate(android.os.Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_ALLOW_BACKUP) != 0) {
                // enabled
                System.out.println("Backup is enabled");
            } else {
                // disabled
                System.out.println("Backup is disabled");
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // The main method is not typically used in Android applications.
    }
}