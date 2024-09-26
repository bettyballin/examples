import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a temporary batch file
            File batchFile = new File("script.bat");
            FileWriter writer = new FileWriter(batchFile);

            // Write the script content to the batch file
            writer.write("@echo off\n");
            writer.write("echo extraction step 1\n");
            writer.write("\"C:\\Program Files\\7-Zip\\7z.exe\" e -r -aos -bd -otmp *\n");
            writer.write("echo creating filelist\n");
            writer.write("\"C:\\Program Files\\7-Zip\\7z.exe\" l -r -aos -bd tmp/* >filelist.txt\n");
            writer.write("echo cleanup\n");
            writer.write("rmdir /s /q tmp\n");
            writer.write("echo analysis result:\n");
            writer.write("find \"JndiLookup.class\" filelist.txt\n");
            writer.write("find \"JMSAppenderBase.class\" filelist.txt\n");
            writer.write("find \"JMSAppender.class\" filelist.txt\n");
            writer.write("pause\n");

            writer.close();

            // Execute the batch file
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "script.bat");
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();

            // Delete the temporary batch file after execution
            batchFile.delete();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}