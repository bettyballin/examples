import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (InputStream input = Main.class.getResourceAsStream("/org/my/foosoft/authn/jaspic-provider.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find jaspic-provider.properties");
                return;
            }
            properties.load(input);
            properties.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


Create a file structure as follows:

/project
    /src
        /main
            /java
                Main.java
            /resources
                /org
                    /my
                        /foosoft
                            authn
                                jaspic-provider.properties


Content for `jaspic-provider.properties`:

property1=value1
property2=value2


To compile and run:
sh
javac -d /project/out /project/src/main/java/Main.java
java -cp /project/out Main