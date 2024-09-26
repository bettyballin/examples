import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;
import android.content.Context;

public class SettingsOpener {
    private Context context;

    public SettingsOpener(Context context) {
        this.context = context;
    }

    public void openUsageAccessSettings() {
        try {
            Intent intent = new Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS);
            context.startActivity(intent);
        } catch (SecurityException e) {
            Toast.makeText(context, "Cannot open usage access settings.", Toast.LENGTH_SHORT).show();
        }
    }
}