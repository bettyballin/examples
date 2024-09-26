import org.apache.commons.text.StringEscapeUtils;

public class Temp1512 {
    public static void main(String[] args) {
        // Simulating myObj and its get method for demonstration purposes
        MyObject myObj = new MyObject();
        String escapedText = StringEscapeUtils.escapeHtml4(myObj.get("fieldName").asText());
        System.out.println(escapedText);
    }
}

// Mock object class for demonstration
class MyObject {
    public Field get(String fieldName) {
        return new Field("Some <html> text with 'special' & characters.");
    }
}

// Mock field class for demonstration
class Field {
    private String text;

    public Field(String text) {
        this.text = text;
    }

    public String asText() {
        return text;
    }
}