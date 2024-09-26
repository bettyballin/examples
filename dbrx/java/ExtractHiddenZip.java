import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ExtractHiddenZip {
    public static void main(String[] args) throws IOException {
        byte[] imageDataAndArchive = Files.readAllBytes(Path.of("hidden.jpg"));

        int splitIndex = findSplitIndex(imageDataAndArchive);
        if (splitIndex == -1) {
            System.err.println("Could not determine the boundary between image data and archive.");
            return;
        }

        ByteArrayInputStream imageStream = new ByteArrayInputStream(
                Arrays.copyOfRange(imageDataAndArchive, 0, splitIndex));
        displayImage(imageStream);

        byte[] zipContent = Arrays.copyOfRange(imageDataAndArchive, splitIndex, imageDataAndArchive.length);
        extractZipFiles(zipContent);
    }

    private static int findSplitIndex(byte[] data) {
        for (int i = 0; i < data.length - 3; ++i) {
            if (data[i] == 'P' && data[i + 1] == 'K' &&
                    data[i + 2] == 3 && data[i + 3] == 4) {
                return i;
            }
        }

        return -1;
    }

    private static void displayImage(InputStream imageStream) throws IOException {
        BufferedImage image = ImageIO.read(imageStream);
        ImageIcon icon = new ImageIcon(image);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 600);
        JLabel lbl = new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void extractZipFiles(byte[] zipContent) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(zipContent);
        ZipInputStream zis = new ZipInputStream(bais);
        ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null) {
            File file = new File(entry.getName());
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
            fos.close();
            zis.closeEntry();
        }
        zis.close();
    }
}