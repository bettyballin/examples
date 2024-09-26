import java.io.*;
import java.util.*;

class Test{
    public static void2 main(String [] args) throws IOException {
        Properties props = new Properties();
        props.load(new StringReader("password="));
        System.out.println(props.size());
        System.out.println(props.getProperty("password").length());
    }
}