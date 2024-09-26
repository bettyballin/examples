import java.nio.file.*;
import java.io.*;

public class DemoApp {
    private static final String TRACKER_FILE_PATH = "demo_usage_tracker.txt";
    private static final int MAX_EXECUTIONS = 5;

    public static void main(String[] args) {
        try {
            if (hasReachedExecutionLimit()) {
                System.out.println("The demo has been used the maximum number of times.");
                return;
            }
            incrementExecutionCount();
            System.out.println("Demo is running.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean hasReachedExecutionLimit() throws IOException {
        Path trackerPath = Paths.get(TRACKER_FILE_PATH);
        if (!Files.exists(trackerPath)) {
            Files.createFile(trackerPath);
            return false;
        }
        String content = new String(Files.readAllBytes(trackerPath));
        int executions = content.isEmpty() ? 0 : Integer.parseInt(content);
        return executions >= MAX_EXECUTIONS;
    }

    private static void incrementExecutionCount() throws IOException {
        Path trackerPath = Paths.get(TRACKER_FILE_PATH);
        if (!Files.exists(trackerPath)) {
            Files.createFile(trackerPath);
        }
        String content = new String(Files.readAllBytes(trackerPath));
        int executions = content.isEmpty() ? 0 : Integer.parseInt(content);
        Files.write(trackerPath, String.valueOf(executions + 1).getBytes());
    }
}