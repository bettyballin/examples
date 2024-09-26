public class Temp1302 {
    public static void main(String[] args) {
        int keyUpper = 0;
        int keyLowerCopy = 1;
        
        keyUpper |= keyLowerCopy << 29;
        
        System.out.println("keyUpper: " + keyUpper);
    }
}