public class Temp3467 {
    public static void main(String[] args) {
        String protocolUsed = "TLSv1.3";
        String expectedMessage;

        if (protocolUsed.equals("TLSv1.3")) {
            expectedMessage = "Empty client certificate chain";
        } else {
            expectedMessage = "Empty server certificate chain";
        }

        System.out.println(expectedMessage);
    }
}