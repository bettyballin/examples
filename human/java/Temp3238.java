public class ChangeJksPassword {
    public static void main(String[] args) {
        String newJksPassword = System.getenv("NEW_JKS_PASSWORD");

        if (newJksPassword != null && !newJksPassword.isEmpty()) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(
                        "/usr/lib/jvm/java-11-openjdk-amd64/bin/keytool",
                        "-storepasswd",
                        "-storepass", "changeit",
                        "-new", newJksPassword,
                        "-cacerts"
                );
                Process process = processBuilder.start();
                process.waitFor();

                System.out.println("Password changed successfully");

                // Prevent the password from leaking
                System.clearProperty("NEW_JKS_PASSWORD");
                System.out.println("Password cleared from environment");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Execute the main process
        if (args.length > 0) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(args);
                processBuilder.inheritIO();
                Process process = processBuilder.start();
                process.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}