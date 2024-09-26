import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WindowsLocalUsers {

    public static List<String> getLocalUsers() throws IOException {
        List<String> users = new ArrayList<>();
        ProcessBuilder processBuilder = new ProcessBuilder("net", "user");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            boolean capture = false;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("----")) {
                    capture = !capture; // Toggle capture on or off
                } else if (capture) {
                    String[] userNames = line.trim().split("\\s+");
                    for (String user : userNames) {
                        if (!user.isEmpty()) {
                            users.add(user);
                        }
                    }
                }
            }
        }
        return users;
    }

    public static void main(String[] args) {
        try {
            List<String> localUsers = getLocalUsers();
            System.out.println("Local users on this machine:");
            for (String user : localUsers) {
                System.out.println(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}