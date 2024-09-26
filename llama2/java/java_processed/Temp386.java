public class Temp386 {
    public static void main(String[] args) {
        IPAddress ip = new IPAddress("127.0.0.1");
        GeneralName ipAddress = new GeneralName(GeneralName.iPAddress, ip.getOctets());
    }
}

class IPAddress {
    private String address;

    public IPAddress(String address) {
        this.address = address;
    }

    public byte[] getOctets() {
        String[] parts = address.split("\\.");
        byte[] octets = new byte[parts.length];
        for (int i = 0; i < parts.length; i++) {
            octets[i] = (byte) Integer.parseInt(parts[i]);
        }
        return octets;
    }
}

class GeneralName {
    public static final int iPAddress = 7;
    private int type;
    private byte[] value;

    public GeneralName(int type, byte[] value) {
        this.type = type;
        this.value = value;
    }

    // Additional methods can be added as needed
}