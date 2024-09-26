import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Temp803 {
    public static void main(String[] args) {
        Document document = new Document();
        try {
            String finalpass = "UserPassword";
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("output.pdf"));
            writer.setEncryption(finalpass.getBytes(), "TheOwnerPassword".getBytes(), PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
            document.open();
            document.add(new com.itextpdf.text.Paragraph("This is a test document."));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}