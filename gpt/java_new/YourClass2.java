import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.content.Context;

public class YourClass2 {
    public void disableComponent(Context context) {
        PackageManager p = context.getPackageManager();
        ComponentName componentName = new ComponentName(context, com.example.YourActivity.class);
        p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
    }
}