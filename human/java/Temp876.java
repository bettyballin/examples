public class Temp876 {

    public static void main(String[] args) {
        // Dummy Bitmap object for demonstration (replace with actual Bitmap object in real use)
        Bitmap bm = new Bitmap(100, 100);

        int[] pixels = new int[bm.getWidth() * bm.getHeight()];
        bm.getPixels(pixels, 0, bm.getWidth(), 0, 0, bm.getWidth(), bm.getHeight());
        encryptIntArray(pixels);
        bm.setPixels(pixels, 0, bm.getWidth(), 0, 0, bm.getWidth(), bm.getHeight());
    }

    // Dummy encryptIntArray method for demonstration (replace with actual encryption logic in real use)
    public static void encryptIntArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = ~array[i]; // Example encryption by bitwise NOT
        }
    }

    // Dummy Bitmap class for demonstration (replace with actual Bitmap class in real use)
    static class Bitmap {
        private int width, height;
        private int[] pixels;

        public Bitmap(int width, int height) {
            this.width = width;
            this.height = height;
            this.pixels = new int[width * height];
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = i; // Initialize with dummy pixel values
            }
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }

        public void getPixels(int[] dest, int offset, int stride, int x, int y, int width, int height) {
            System.arraycopy(pixels, 0, dest, offset, this.pixels.length);
        }

        public void setPixels(int[] src, int offset, int stride, int x, int y, int width, int height) {
            System.arraycopy(src, offset, pixels, 0, src.length);
        }
    }
}