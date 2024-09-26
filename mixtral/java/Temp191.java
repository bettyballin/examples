import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.X500Name;

public class Temp191 {
    public static void main(String[] args) {
        X500NameBuilder builder = new X500NameBuilder(BCStyle.INSTANCE);
        builder.addRDN(BCStyle.CN, "Requested Test Certificate");
        // Add more RDNs as needed

        X500Name subjectDN = builder.build();
        System.out.println(subjectDN);
    }
}


To run this code, you need to include BouncyCastle library in your project. If you are using Maven, you can add the following dependency to your `pom.xml`:

xml
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcprov-jdk15on</artifactId>
    <version>1.70</version>
</dependency>
<dependency>
    <groupId>org.bouncycastle</groupId>
    <artifactId>bcpkix-jdk15on</artifactId>
    <version>1.70</version>
</dependency>