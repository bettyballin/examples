import java.io.IOException;

public class Temp1765 {
    public static void main(String[] args) {
        try {
            Process process1 = Runtime.getRuntime().exec("mknod -m 644 /dev/random c 1 8");
            process1.waitFor();
            Process process2 = Runtime.getRuntime().exec("mknod -m 644 /dev/urandom c 1 9");
            process2.waitFor();
            Process process3 = Runtime.getRuntime().exec("chown root:root /dev/random /dev/urandom");
            process3.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}