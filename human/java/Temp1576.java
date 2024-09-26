import java.util.prefs.Preferences;

public class Temp1576 {
    public static void main(String[] args) {
        Preferences prefs = Preferences.userRoot().node(Temp1576.class.getName());
        
        int pin = 1234; // Example pin
        int defaultPin = 0; // Example default value
        
        prefs.putInt("userPin", pin);

        int retrievedPin = prefs.getInt("userPin", defaultPin);

        System.out.println("Retrieved Pin: " + retrievedPin);
    }
}