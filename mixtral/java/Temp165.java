import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Temp165 {
    public static void main(String[] args) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("encrypted.pdf"));
            String userPassword = "finalpass";
            String ownerPassword = "finalpass";
            writer.setEncryption(userPassword.getBytes(), ownerPassword.getBytes(),
                    PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ASSEMBLE | PdfWriter.ALLOW_PRINTING,
                    PdfWriter.STANDARD_ENCRYPTION_128);
            document.open();
            document.add(new com.itextpdf.text.Paragraph("Hello, World!"));
            document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}