public class Temp1495 {
    public static void main(String[] args) {
        ExtendedMetadata extendedMetadata = new ExtendedMetadata();
        extendedMetadata.setIdpDiscoveryEnabled(true); 
        extendedMetadata.setSignMetadata(false);
        // Additional code if needed...
    }
}

class ExtendedMetadata {
    private boolean idpDiscoveryEnabled;
    private boolean signMetadata;

    public void setIdpDiscoveryEnabled(boolean idpDiscoveryEnabled) {
        this.idpDiscoveryEnabled = idpDiscoveryEnabled;
    }

    public void setSignMetadata(boolean signMetadata) {
        this.signMetadata = signMetadata;
    }
}