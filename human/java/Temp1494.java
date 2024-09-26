public class Temp1494 {
    public static void main(String[] args) {
        ExtendedMetadataDelegate extendedMetadataDelegate = new ExtendedMetadataDelegate();
        extendedMetadataDelegate.setMetadataTrustCheck(true);
        extendedMetadataDelegate.setMetadataRequireSignature(false);
    }
}

class ExtendedMetadataDelegate {
    private boolean metadataTrustCheck;
    private boolean metadataRequireSignature;

    public void setMetadataTrustCheck(boolean metadataTrustCheck) {
        this.metadataTrustCheck = metadataTrustCheck;
    }

    public void setMetadataRequireSignature(boolean metadataRequireSignature) {
        this.metadataRequireSignature = metadataRequireSignature;
    }
}