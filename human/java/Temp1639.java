import java.util.HashMap;
import java.util.Map;

public class Temp1639 {
    public static void main(String[] args) {
        Map<String, Map<String, Object>> notes = new HashMap<>();
        Map<String, Object> noteDetails = new HashMap<>();
        noteDetails.put("text", "I like taking notes.");
        noteDetails.put("uid", "user_1");
        notes.put("0", noteDetails);

        Map<String, Map<String, Boolean>> sharedNotes = new HashMap<>();
        Map<String, Boolean> sharedUsers = new HashMap<>();
        sharedUsers.put("user_1", true);
        sharedUsers.put("user_2", true);
        sharedNotes.put("0", sharedUsers);

        System.out.println("Notes: " + notes);
        System.out.println("Shared Notes: " + sharedNotes);
    }
}