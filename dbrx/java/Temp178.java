import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;

public class Temp178 {
    public static void main(String[] args) {
        String src = "source.pdf"; // Replace with your source PDF path
        String dest = "encrypted.pdf"; // Replace with your desired encrypted PDF path
        String finalpass = "your_password"; // Replace with your desired password

        try {
            PdfWriter writer = new PdfWriter(dest, new WriterProperties().setStandardEncryption(
                finalpass.getBytes(), 
                finalpass.getBytes(), 
                PdfWriter.ALLOW_PRINTING,
                PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA
            ));

            PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), writer);
            pdfDoc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}