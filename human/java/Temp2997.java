import java.util.Arrays;

public class Temp2997 {
    private static final int INITIALISATION_VECTOR_LENGTH = 12; // Example length
    private static final int GCM_AUTHENTICATION_TAG_SIZE = 16; // Example length

    public static void main(String[] args) {
        // Example receivedPacket for demonstration purposes
        byte[] receivedPacket = new byte[INITIALISATION_VECTOR_LENGTH + GCM_AUTHENTICATION_TAG_SIZE + 20]; // Example size

        // Fill receivedPacket with example data
        for (int i = 0; i < receivedPacket.length; i++) {
            receivedPacket[i] = (byte) i;
        }

        byte[] initialisationVector = Arrays.copyOfRange(receivedPacket, 0, INITIALISATION_VECTOR_LENGTH);
        byte[] tag = Arrays.copyOfRange(receivedPacket, INITIALISATION_VECTOR_LENGTH, INITIALISATION_VECTOR_LENGTH + GCM_AUTHENTICATION_TAG_SIZE);
        byte[] associatedData = Arrays.copyOfRange(receivedPacket, INITIALISATION_VECTOR_LENGTH + GCM_AUTHENTICATION_TAG_SIZE, receivedPacket.length);

        // Print the arrays to verify correct slicing
        System.out.println("Initialisation Vector: " + Arrays.toString(initialisationVector));
        System.out.println("Tag: " + Arrays.toString(tag));
        System.out.println("Associated Data: " + Arrays.toString(associatedData));
    }
}