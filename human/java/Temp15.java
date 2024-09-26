public class Temp15 {
    public static void main(String[] args) {
        String lineSeparator = java.security.AccessController.doPrivileged(
            new java.security.PrivilegedAction<String>() {
                public String run() {
                    return System.getProperty("line.separator");
                }
            }
        );
        System.out.println("Line separator is: " + lineSeparator.replace("\n", "\\n").replace("\r", "\\r"));
    }
}