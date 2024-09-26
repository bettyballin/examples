import java.io.File;

public class FileListing {
    public static void main(String[] args) throws Exception {
        // Set the root directory to the local folder
        File root = new File("Data folder");

        // Check if the root directory exists and is indeed a directory
        if (root.exists() && root.isDirectory()) {
            // Walk through all files and directories within the root
            for (File file : root.listFiles()) {
                System.out.println(file.getName());
            }
        } else {
            System.out.println("The specified root directory does not exist or is not a directory.");
        }
    }
}