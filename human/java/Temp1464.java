import java.io.IOException;

public class Temp1464 {
    public static void main(String[] args) {
        String fileLoc = "/var/tmp/myImage.jpg";
        String[] cmd = {"chmod", "0444", fileLoc};
        ProcessBuilder pb = new ProcessBuilder(cmd);
        try {
            Process process = pb.start();
            int error = process.waitFor();
            if (error != 0){
                // non 0 means something bad happened
                System.out.println("Error occurred while changing file permissions.");
            } else {
                System.out.println("File permissions changed successfully.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}