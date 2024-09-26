public class Temp1852 {
    public static void main(String[] args) {
        String keyBase64 = "uQsaW+WMUrjcsq1HMf+2JQ==";
        byte[] keyBytes = java.util.Base64.getDecoder().decode(keyBase64);
        System.out.println(java.util.Arrays.toString(keyBytes));
    }
}