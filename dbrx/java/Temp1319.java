import javax.xml.stream.XMLInputFactory;

public class Temp1319 {
    public static void main(String[] args) throws Exception {

        XMLInputFactory xif = XMLInputFactory.newFactory();
        xif.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, false);
        xif.setProperty(XMLInputFactory.SUPPORT_DTD, false);

    }
}