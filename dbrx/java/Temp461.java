import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp461 {
    public static void main(String[] args) {
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            String firstLine = bf.readLine();
            System.out.println(firstLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}