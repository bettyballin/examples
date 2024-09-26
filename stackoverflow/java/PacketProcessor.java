import java.util.Arrays;

public class PacketProcessor {
    private static final int INITIALISATION_VECTOR_LENGTH = 16; // Assuming a length
    private static final int GCM_AUTHENTICATION_TAG_SIZE = 16; // Assuming a size

    public void processPacket(byte[] receivedPacket) {
        byte[] initialisationVector = Arrays.copyOfRange(receivedPacket, 0, INITIALISATION_VECTOR_LENGTH);
        byte[] tag = Arrays.copyOfRange(receivedPacket, INITIALISATION_VECTOR_LENGTH, INITIALISATION_VECTOR_LENGTH + GCM_AUTHENTICATION_TAG_SIZE);
        byte[] associatedData = Arrays.copyOfRange(receivedPacket, INITIALISATION_VECTOR_LENGTH + GCM_AUTHENTICATION_TAG_SIZE, receivedPacket.length);
        
        // Process the extracted data.
    }
    
    // Other methods ...
}