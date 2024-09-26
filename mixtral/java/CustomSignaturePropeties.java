import java.util.ArrayList;
import java.util.List;

class SignatureProperties {
    protected String c14nAlgorithm;
    protected List<String> accceptedC14nAlgorithms = new ArrayList<>();

    public SignatureProperties() {
        // Initialize with default values if needed
    }
}

public class CustomSignatureProperties extends SignatureProperties {
    public CustomSignatureProperties() {
        super();

        // Override default canonicalization algorithm
        c14nAlgorithm = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";

        accceptedC14nAlgorithms.add(c14nAlgorithm);
    }

    public static void main(String[] args) {
        CustomSignatureProperties customProps = new CustomSignatureProperties();
        System.out.println("Canonicalization Algorithm: " + customProps.c14nAlgorithm);
        System.out.println("Accepted C14n Algorithms: " + customProps.accceptedC14nAlgorithms);
    }
}