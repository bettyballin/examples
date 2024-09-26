import javax.xml.bind.JAXBContext;
import javax.xml.stream.XMLInputFactory;

public class Main {
    public static void main(String[] args) {
        try {
            // Assuming Manifest.class is a valid class for JAXB context
            JAXBContext jc = JAXBContext.newInstance(Manifest.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
            
            System.out.println("JAXBContext and XMLInputFactory configured successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Placeholder class for Manifest
    // Replace this with the actual Manifest class
    public static class Manifest {
        // Fields, constructors, methods, etc.
    }
}