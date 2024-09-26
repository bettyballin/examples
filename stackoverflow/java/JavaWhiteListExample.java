import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaWhiteListExample {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String directoryName = "Bob";
        String filePath;
        FileWriter stream = null;
        String text = "some text";
        System.out.print("Enter a file to write to: ");
        filePath = scanner.nextLine();
        String WHITELIST = "^[0-9A-Za-z]+$";
        Pattern p = Pattern.compile(WHITELIST);
        Matcher m = p.matcher(filePath);

        if(!m.matches()){
            System.out.println("Invalid input.");
        }else{
            try{
                File toWrite = new File(directoryName, filePath);
                if(!toWrite.exists() && !toWrite.isDirectory()) {
                    stream = new FileWriter(toWrite);
                    stream.write(text);
                }
            } catch(IOException e){
                e.printStackTrace();
            } finally {
                try {
                    if(stream != null){
                        stream.close();
                    }
                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        scanner.close();
    }
}