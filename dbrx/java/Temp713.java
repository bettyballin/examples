import org.owasp.validator.html.*;

public class Temp713 {
    public static void main(String[] args) {
        String dirtyInput = "<script>alert('XSS');</script> Hello World!";
        try {
            Policy policy = Policy.getInstance(Temp713.class.getResourceAsStream("antisamy-slashdot.xml"));
            AntiSamy antiSamy = new AntiSamy();
            CleanResults cleanResults = antiSamy.scan(dirtyInput, policy);
            String cleanInput = cleanResults.getCleanHTML();
            cleanInput = cleanInput.replaceAll("\\s+", " ");
            System.out.println(cleanInput);
        } catch (PolicyException | ScanException e) {
            e.printStackTrace();
        }
    }
}

Note: Make sure the "antisamy-slashdot.xml" file is in the same package as the Temp713 class. If it's in a different location, you'll need to adjust the path accordingly. 

Also, ensure you have the OWASP AntiSamy library in your classpath. If you're using Maven, add this dependency to your pom.xml:

xml
<dependency>
    <groupId>org.owasp.antisamy</groupId>
    <artifactId>antisamy</artifactId>
    <version>1.5.7</version>
</dependency>