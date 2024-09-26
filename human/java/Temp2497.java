import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

public class Temp2497 {
    public static void main(String[] args) {
        try {
            // Open putty.exe
            ProcessBuilder builder = new ProcessBuilder("path/to/putty.exe");
            Process putty = builder.start();
            putty.waitFor(5, TimeUnit.SECONDS); // Give it some time to open

            // Get clipboard content
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            String password = (String) clipboard.getData(DataFlavor.stringFlavor);

            // Simulate right click (assuming some predefined coordinates)
            Robot robot = new Robot();
            robot.mouseMove(500, 400); // Example coordinates, may need adjustment
            robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

            // Ensure the putty window is in focus (may need further adjustment)
            String puttyWindowTitle = "putty"; // Adjust the title as necessary
            Path script = Files.createTempFile("focus_putty", ".vbs");
            Files.write(script, String.format(
                "Set WshShell = WScript.CreateObject(\"WScript.Shell\")\n" +
                "WshShell.AppActivate \"%s\"\n", puttyWindowTitle).getBytes());
            new ProcessBuilder("wscript", script.toString()).start();
            script.toFile().deleteOnExit();

        } catch (InterruptedException | IOException | UnsupportedFlavorException | AWTException e) {
            e.printStackTrace();
        }
    }
}