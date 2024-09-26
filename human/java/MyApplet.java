import javax.swing.JApplet;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class MyApplet extends JApplet {
    private IHelper pHelper = null;
    private MyReturnedInfo pInfo = null;

    public interface IHelper extends Library {
        MyReturnedInfo GetInfo();
    }

    public static class MyReturnedInfo {
        public String MyInfoString;
    }

    public void init() {
        pHelper = (IHelper) Native.loadLibrary(
            Platform.isWindows() ? "Helper" : "helper", IHelper.class);
        if (pHelper != null) {
            pInfo = pHelper.GetInfo();
        }
    }

    public String GetInfoString() {
        if (pInfo != null) {
            return pInfo.MyInfoString;
        }
        return null;
    }

    // Main method to run the applet as a standalone application for testing purposes
    public static void main(String[] args) {
        MyApplet applet = new MyApplet();
        applet.init();
        System.out.println("Info String: " + applet.GetInfoString());
    }
}