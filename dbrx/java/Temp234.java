import java.io.*;

public class Temp234 {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream("input.txt");
            os = new FileOutputStream("output.txt");
            byte[] b = new byte[1024];
            int i;
            while ((i = is.read(b)) != -1) {
                os.write(b, 0, i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
                if (os != null) os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}