import java.io.IOException;

public class Temp1936 {
    public static void main(String[] args) {
        try {
            // Adjust the path to the location of your private_key.pem file
            String command = "openssl rsa -in private_key.pem -pubout -outform DER -out public_key.der";
            Process process = Runtime.getRuntime().exec(command);
            process.waitFor();
            System.out.println("Command executed successfully");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}