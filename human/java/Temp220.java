import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Temp220 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int result = JOptionPane.showConfirmDialog(null, "Session timeout. Do you want to log in again?", "Session Timeout", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    // Logic to redirect to login page
                    System.out.println("Redirecting to login page...");
                    // In a real application, this would be an actual redirect.
                }
            }
        }, 15 * 60 * 1000); // 15 minutes
    }
}