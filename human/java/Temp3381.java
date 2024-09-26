// Save this as Temp3381.java
public class Temp3381 {
    public static void main(String[] args) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(
                "java", "-cp", "mssql-jdbc-8.4.1.jre8.jar:.", "JdbcSQLServerConnection"
            );
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}