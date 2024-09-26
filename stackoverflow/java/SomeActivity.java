import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

public class SomeActivity extends Activity {
    // Other parts of the class

    private boolean canPerformIntent(Context context, Intent intent) {
        return intent.resolveActivity(context.getPackageManager()) != null;
    }

    private void someMethod() {
        if (canPerformIntent(this, new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS))) {
            startActivity(new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS));
        }
    }
}