import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.IOException;
import org.apache.commons.io.input.BoundedInputStream;
import java.io.StringReader;

public class Temp460 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(
            new BoundedInputStream(getInfiniteReader(), 1024 * 10)
        ));

        String line;
        while ((line = bf.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static Reader getInfiniteReader() {
        StringBuilder infiniteString = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            infiniteString.append("This is line number " + i + "\n");
        }
        return new StringReader(infiniteString.toString());
    }
}