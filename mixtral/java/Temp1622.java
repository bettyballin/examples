import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class Temp1622 {
    public static void main(String[] args) {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_NUM_LOCK);
            // Enter Password
            robot.keyRelease(KeyEvent.VK_NUM_LOCK);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}