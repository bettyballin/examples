public class Temp204 {
    public static void main(String[] args) {
        String myKey = "mysecretkey";
        int keyLength = 16; // AES-128

        byte[] encryptedData = new Temp204().encrypt(myKey, keyLength);
        // Handle encryptedData as needed
    }

    public native byte[] encrypt(String keyStr, int length);

    static {
        System.loadLibrary("MyLib");
    }
}