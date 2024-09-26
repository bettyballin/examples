import java.util.regex.Pattern;

public class Temp3417 {
    public static void main(String[] args) {
        String variable1 = "someValue1";
        String variable2 = "someValue2";
        
        Pattern patternCheck = Pattern.compile(
            "check\\s+test\\s+([\\w\\s-]+)cd(\\s+" 
            + Pattern.quote(variable1) 
            + "|\\s+abc\\s+" 
            + Pattern.quote(variable2) 
            + ")\\s+to\\s+(abc|xyz)\\s+test\\s+ab\\s+xyz", 
            Pattern.CASE_INSENSITIVE
        );
    }
}