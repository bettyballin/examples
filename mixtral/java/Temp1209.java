import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.functions.FirebaseFunctions;
import com.google.firebase.functions.HttpsCallableResult;
import com.google.firebase.functions.HttpsError;

public class Temp1209 {
    
    public static void main(String[] args) {
        Temp1209 temp = new Temp1209();
        temp.validateTimestamp();
    }

    public void validateTimestamp() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/latest/{id}/{param}");

        FirebaseFunctions functions = FirebaseFunctions.getInstance();

        ref.onWrite((change, context) -> {
            Object newData = change.getAfter().getValue();

            if (newData != null && newData instanceof Map && ((Map) newData).containsKey("timestamp")) {
                boolean isValid = true;

                if (((Map) newData).containsKey("value") || !change.getBefore().exists()) {
                    Long newTimestamp = (Long) ((Map) newData).get("timestamp");
                    Long currentTimestamp = (Long) change.getAfter().child(context.getParams().get("param")).child("timestamp").getValue();
                    isValid = newTimestamp >= currentTimestamp;
                }

                if (!isValid) {
                    throw new HttpsError("invalid-argument", "Invalid timestamp");
                }
            }
            return null;
        });
    }
}