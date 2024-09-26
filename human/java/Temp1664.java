public class Temp1664 {

    static {
        System.loadLibrary("library-name");
    }

    public native String getSecretKey();

    public static void main(String[] args) {
        Temp1664 temp = new Temp1664();
        String secretKey = temp.getSecretKey();
        System.out.println("Secret Key: " + secretKey);
    }
}