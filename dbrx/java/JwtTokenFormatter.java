import java.util.Locale;

public class JwtTokenFormatter implements Formatter<String> {

    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_PREFIX = "Bearer ";

    @Override
    public String print(String jwtToken, Locale locale) {
        return BEARER_PREFIX + jwtToken;
    }

    @Override
    public String parse(String text, Locale locale) throws ParseException {
        if (text.startsWith(BEARER_PREFIX)) {
            return text.substring(BEARER_PREFIX.length());
        }
        throw new ParseException("Invalid JWT token format", 0);
    }

    public static void main(String[] args) {
        JwtTokenFormatter formatter = new JwtTokenFormatter();
        String jwtToken = "example.jwt.token";
        String formattedToken = formatter.print(jwtToken, Locale.getDefault());
        System.out.println("Formatted Token: " + formattedToken);

        try {
            String parsedToken = formatter.parse(formattedToken, Locale.getDefault());
            System.out.println("Parsed Token: " + parsedToken);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}

interface Formatter<T> {
    String print(T object, Locale locale);
    T parse(String text, Locale locale) throws ParseException;
}

class ParseException extends Exception {
    public ParseException(String message, int errorOffset) {
        super(message);
    }
}