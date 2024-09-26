import java.applet.Applet;
import java.util.prefs.Preferences;

public class MyApplet extends Applet {
    public void init() {
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        String config = prefs.get("configKey", "defaultConfig");
        // Use the configuration...
    }

    public void saveConfig(String config) {
        Preferences prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.put("configKey", config);
    }
}