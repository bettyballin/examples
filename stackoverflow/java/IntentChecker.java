import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

public class IntentChecker {

    public static boolean canPerformIntent(Context context, Intent intent) {
        PackageManager mgr = context.getPackageManager();
        List<?> list = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}