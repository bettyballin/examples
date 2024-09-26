import javax.xml.bind.JAXBContext;
import javax.xml.stream.XMLInputFactory;

public class Main92 {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Manifest.class);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
            xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Assuming Manifest.class is a placeholder for an actual JAXB-annotated class
    static class Manifest {
        // JAXB-annotated fields go here
    }
}