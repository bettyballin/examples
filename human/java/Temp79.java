public class Temp79 {
    public static void main(String[] args) {
        if (isRootUser()) {
            System.out.println("You are root, go away!");
            System.exit(1);
        }
    }

    private static boolean isRootUser() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            // On Windows, there is no concept of root user like in Unix-based systems.
            return false;
        } else {
            try {
                Process process = Runtime.getRuntime().exec(new String[]{"id", "-u"});
                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(process.getInputStream()));
                String userId = reader.readLine().trim();
                return "0".equals(userId);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}