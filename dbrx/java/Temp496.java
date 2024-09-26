import org.springframework.security.access.prepost.PreAuthorize;

public class Temp496 {

    public static void main(String[] args) {
        Temp496 temp = new Temp496();
        temp.findWidgetById(123L);
    }

    @PreAuthorize("hasPermission(#widgetId, 'com.example.Widget', 'read')")
    public Widget findWidgetById(Long widgetId) {
        // Example implementation
        System.out.println("Finding widget by ID: " + widgetId);
        return new Widget(widgetId);
    }

    class Widget {
        Long id;

        Widget(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Widget{id=" + id + '}';
        }
    }
}