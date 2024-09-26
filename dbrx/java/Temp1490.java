import javax.xml.stream.XMLInputFactory;

public class Temp1490 {
    public static void main(String[] args) {
        try {
            XMLInputFactory xif = XMLInputFactory.newInstance();
            System.out.println("XMLInputFactory instance created: " + xif);
        } catch (Exception e) {
            System.err.println("Error creating XMLInputFactory instance: " + e.getMessage());
        }
    }
}