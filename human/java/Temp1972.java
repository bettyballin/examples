public class Temp1972 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command("bash", "-c", "asadmin enable-secure-admin --adminalias=myNewAlias --instancealias myNewAlias");

            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}