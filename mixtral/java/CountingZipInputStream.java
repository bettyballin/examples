import java.io.*;
import java.util.zip.*;

public class CountingZipInputStream extends FilterInputStream {
    private long count;

    public CountingZipInputStream(final InputStream in) {
        super(in);
        this.count = 0L;
    }

    @Override
    public int read() throws IOException {
        final int c = super.read();

        if (c != -1)
            count++;

        return c;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int bytesRead = super.read(b, off, len);
        if (bytesRead != -1) {
            count += bytesRead;
        }
        return bytesRead;
    }

    @Override
    public long skip(long n) throws IOException {
        long bytesSkipped = super.skip(n);
        count += bytesSkipped;
        return bytesSkipped;
    }

    public long getCount() {
        return this.count;
    }
}

public class ZipBombDetector {

    private static final long MAX_TOTAL = 1024 * 1024L; // Set your own limit

    public void detectZipBombs(InputStream inputStream) throws IOException, IllegalArgumentException {
        try (CountingZipInputStream countingIn = new CountingZipInputStream(inputStream);
             ZipInputStream zipInput = new ZipInputStream(countingIn))
        {
            for (ZipEntry entry; (entry = zipInput.getNextEntry()) != null; ) {
                if (!isSafeToExtract(zipInput, countingIn.getCount())) {
                    throw new IllegalArgumentException("Potential zip bomb detected");
                }
                // Simulate extraction by reading the entry
                byte[] buffer = new byte[1024];
                while (zipInput.read(buffer) != -1) {
                    // No-op
                }
            }
        }
    }

    private boolean isSafeToExtract(ZipInputStream zipInput, long currentCount) {
        return currentCount <= MAX_TOTAL;
    }

    public static void main(String[] args) {
        ZipBombDetector detector = new ZipBombDetector();
        try (FileInputStream fis = new FileInputStream("test.zip")) {
            detector.detectZipBombs(fis);
            System.out.println("No zip bomb detected.");
        } catch (IOException | IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}