import java.io.IOException;

public class RunApp {
    public static void main(String[] args) throws IOException {
        String command = "notepad.exe";
        if (System.getProperty("os.name").startsWith("Windows")) {
            command = System.getenv("windir") + "\\system32\\" + command;
        }
        ProcessBuilder pb = new ProcessBuilder(command);
        pb.start();
    }
}