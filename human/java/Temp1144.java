import java.io.*;
import java.util.*;

class Test{
    public static void main(String [] args) throws Exception {
        Properties props = new Properties();
        props.load(new StringReader("password="));
        System.out.println(props.size()); // 1
        String password = props.getProperty("password");
        System.out.println(password == null ? 0 : password.length()); // 0
    }
}