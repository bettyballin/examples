import java.io.IOException;

public class Temp1267 {
    public static void main(String[] args) {
        try {
            ProcessBuilder builder = new ProcessBuilder(
                "cmd.exe", "/c", "\"<installdir>\\glassfish\\bin\\appclient.bat -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -client <dir>\\TEMPSClient.jar\"");
            builder.redirectErrorStream(true);
            Process process = builder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}