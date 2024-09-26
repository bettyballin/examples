import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.io.CharacterEscapes;

public class Main11 {
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.getFactory().setCharacterEscapes(new HtmlCharacterEscapes());
            YourObject yourObject = new YourObject(); // Replace with your actual object
            String safeJson = mapper.writeValueAsString(yourObject);
            System.out.println(safeJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}

class YourObject {
    // Define the properties of your object with getters and setters
}

class HtmlCharacterEscapes extends CharacterEscapes {
    private final int[] asciiEscapes;

    public HtmlCharacterEscapes() {
        // define the escapes
        asciiEscapes = CharacterEscapes.standardAsciiEscapesForJSON();
        // customize escapes for HTML
        asciiEscapes['<'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['>'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['&'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['"'] = CharacterEscapes.ESCAPE_CUSTOM;
        asciiEscapes['\''] = CharacterEscapes.ESCAPE_CUSTOM;
    }

    @Override
    public int[] getEscapeCodesForAscii() {
        return asciiEscapes;
    }

    @Override
    public SerializableString getEscapeSequence(int ch) {
        // provide custom escape sequences if needed
        return null;
    }
}