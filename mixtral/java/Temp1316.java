import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;

import java.util.ArrayList;
import java.util.List;

public class Temp1316 {
    public static void main(String[] args) {
        List<GeneralName> namesList = new ArrayList<>();
        namesList.add(new GeneralName(GeneralName.iPAddress, "127.0.0.1"));
        namesList.add(new GeneralName(GeneralName.iPAddress, "::1"));

        GeneralNames generalNames = new GeneralNames(namesList.toArray(new GeneralName[0]));

        // Display the GeneralNames
        System.out.println(generalNames);
    }
}