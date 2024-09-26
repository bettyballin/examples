import java.io.IOException;

public class Temp1766 {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb1 = new ProcessBuilder("rm", "/dev/random");
            ProcessBuilder pb2 = new ProcessBuilder("mknod", "-m", "644", "/dev/random", "c", "1", "9");
            ProcessBuilder pb3 = new ProcessBuilder("chown", "root:root", "/dev/random");

            pb1.inheritIO().start().waitFor();
            pb2.inheritIO().start().waitFor();
            pb3.inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}