import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class EncryptionExample1 {
    public void encryptPdf(PdfWriter writer, String userPassword, String ownerPassword) throws DocumentException {
        writer.setEncryption(PdfWriter.ENCRYPTION_AES_128, userPassword.getBytes(), ownerPassword.getBytes(), PdfWriter.ALLOW_PRINTING);
    }
}