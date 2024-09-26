public class Temp1208 {
    public static void main(String[] args) {
        // Assuming msgback is some predefined object with a toByteArray method
        // Since it's not defined in the provided code, we'll create a mock version
        MockMsgBack msgback = new MockMsgBack("Hello, World!");

        byte[] msgBackBytes = msgback.toByteArray();
        String decryptedMessage = new String(msgBackBytes);
        System.out.println("Decrypted message is: " + decryptedMessage);
    }
}

// Mock class to simulate the msgback object with a toByteArray method
class MockMsgBack {
    private final String message;

    public MockMsgBack(String message) {
        this.message = message;
    }

    public byte[] toByteArray() {
        return message.getBytes();
    }
}