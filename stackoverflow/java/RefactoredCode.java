import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;

public class RefactoredCode {
    public void processFile(InputStream inputStream, OutputStream outputStream, Cipher cipher) throws IOException {
        DataInputStream dis = new DataInputStream(inputStream);
        byte[] byteBuffer = new byte[inputStream.available()];
        dis.readFully(byteBuffer);
        dis.close();
        
        CipherOutputStream cos = new CipherOutputStream(outputStream, cipher);
        cos.write(byteBuffer);
        cos.close();
    }
}