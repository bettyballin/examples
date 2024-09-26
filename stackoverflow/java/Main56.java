import java.io.IOException;

public class Main56 {
    public static void main(String[] args) {
        String fileLoc = "/var/tmp/myImage.jpg";
        String[] cmd = {"chmod", "0444", fileLoc};
        ProcessBuilder pb = new ProcessBuilder(cmd);
        try {
            Process process = pb.start();
            int error = process.waitFor();
            if (error != 0) {
                // non 0 means something bad happened
                System.err.println("An error occurred while changing file permissions.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}