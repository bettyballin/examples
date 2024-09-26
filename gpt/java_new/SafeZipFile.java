import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class SafeZipFile extends ZipFile {

    private static final double MAX_COMPRESSION_RATIO = 10.0;

    public SafeZipFile(String name) throws IOException {
        super(name);
    }

    @Override
    public InputStream getInputStream(ZipEntry entry) throws IOException {
        InputStream is = super.getInputStream(entry);
        long uncompressedSize = entry.getSize();
        if (uncompressedSize != -1) {
            long compressedSize = entry.getCompressedSize();
            double compressionRatio = (double) uncompressedSize / compressedSize;
            if (compressionRatio > MAX_COMPRESSION_RATIO) {
                throw new IOException("The compression ratio exceeds the allowed limit.");
            }
        }
        return new CountingInputStream(is);
    }

    private static class CountingInputStream extends FilterInputStream {
        protected CountingInputStream(InputStream in) {
            super(in);
        }

        // Implement the counting logic if necessary
    }
}