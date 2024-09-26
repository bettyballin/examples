public class Temp2610 {
    public static void main(String[] args) {
        // The following line is not valid Java code and should be removed or corrected
        // jdk.tls.disabledAlgorithms=SSLv3, RC4, MD5withRSA, DH keySize < 1024;
        
        // If you need to set this property, it should be set as a system property like this:
        System.setProperty("jdk.tls.disabledAlgorithms", "SSLv3, RC4, MD5withRSA, DH keySize < 1024");
        
        // You can also print out the property to verify it's set correctly
        String disabledAlgorithms = System.getProperty("jdk.tls.disabledAlgorithms");
        System.out.println("Disabled Algorithms: " + disabledAlgorithms);
    }
}