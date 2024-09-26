import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Temp2570 {
    public static void main(String[] args) {
        String localFilename = "example.txt"; // specify the local filename here
        String msg;

        File source = new File(localFilename);
        File dest = new File("C:/E360/CadIntegration/" + localFilename);
        
        try {
            Files.copy(source.toPath(), dest.toPath());
            msg = "Because IP was blank, file was copied to C:/E360/CadIntegration";
        } catch (IOException ex) {
            msg = "problem copying " + source.toPath() + " to " + dest.toPath();
            System.out.println("uploadCadChanges: " + msg + ", IOException is " + ex.getMessage());
        }
    }
}