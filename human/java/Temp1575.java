import android.content.Context;
import android.content.SharedPreferences;
import com.securepreferences.SecurePreferences;

public class Temp1575 {
    public static void main(String[] args) {
        // Assuming we have a context object from an Android application
        Context context = getContextFromSomewhere();
        SharedPreferences prefs = new SecurePreferences(context, null, "my_custom_prefs.xml");

        // Example usage of the preferences
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("key", "value");
        editor.apply();

        String value = prefs.getString("key", "default_value");
        System.out.println("Retrieved value: " + value);
    }

    // Mock method to simulate getting a context in a real Android app
    private static Context getContextFromSomewhere() {
        // In a real Android app, you would get the context from an Activity, Service, etc.
        return null;
    }
}