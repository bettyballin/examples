import javax.swing.JApplet;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class Temp737 extends JApplet {

    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    add(new JLabel("Applet loaded successfully!"));
                }
            });
        } catch (Exception e) {
            System.err.println("Applet initialization failed.");
        }
    }

    public static void main(String[] args) {
        // Applets do not have main methods.
        // They are meant to be run in an applet viewer or browser.
        System.out.println("This is an applet and should be run in an applet viewer or browser.");
    }
}