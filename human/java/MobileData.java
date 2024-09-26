public class MobileData {
    byte publicKeyEncoded[];

    public static void main(String[] args) {
        MobileData md = new MobileData();
        md.publicKeyEncoded = new byte[]{1, 2, 3, 4, 5}; // Example initialization

        // Printing out the byte array
        for (byte b : md.publicKeyEncoded) {
            System.out.print(b + " ");
        }
    }
}