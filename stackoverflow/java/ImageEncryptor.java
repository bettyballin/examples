// Assuming 'bm' is a Bitmap object and 'encryptIntArray' is a method that modifies an int array

import android.graphics.Bitmap;

public class ImageEncryptor {
    void encryptImage(Bitmap bm) {
        int[] pixels = new int[bm.getWidth() * bm.getHeight()];
        bm.getPixels(pixels, 0, bm.getWidth(), 0, 0, bm.getWidth(), bm.getHeight());
        encryptIntArray(pixels);
        bm.setPixels(pixels, 0, bm.getWidth(), 0, 0, bm.getWidth(), bm.getHeight());
    }
    
    private void encryptIntArray(int[] array) {
        // Encryption logic here
    }
}