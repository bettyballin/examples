public class Temp1724 {
    public static void main(String[] args) {
        // Example array of paths to be matched
        String[] paths = {"/css/**", "/js/**", "/img/**", "**/favicon.ico"};

        // Output the paths to simulate the matcher functionality
        for (String path : paths) {
            System.out.println("Anonymous access allowed for: " + path);
        }
    }
}