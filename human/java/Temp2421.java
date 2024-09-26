import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import java.util.List;

public class Temp2421 {
    public static void main(String[] args) {
        // Example usage (context and intent need to be provided here)
    }

    public static boolean canPerformIntent(Context context, Intent intent) {
        PackageManager mgr = context.getPackageManager();
        List activities = mgr.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
        return activities.size() > 0;
    }
}