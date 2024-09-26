public class CSPReport {
    private String documentURI;
    // Add other fields as needed

    // Getters and setters
    public String getDocumentURI() {
        return documentURI;
    }

    public void setDocumentURI(String documentURI) {
        this.documentURI = documentURI;
    }

    // Main method for testing
    public static void main(String[] args) {
        CSPReport report = new CSPReport();
        report.setDocumentURI("http://example.com");
        System.out.println("Document URI: " + report.getDocumentURI());
    }
}