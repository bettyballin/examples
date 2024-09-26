import java.util.List;
import java.util.ArrayList;

public class Temp2143 {
    public static void main(String[] args) {
        Temp2143 app = new Temp2143();
        List<Record> records = app.findAllRecords();
        for (Record record : records) {
            System.out.println(record);
        }
    }

    @PostFilter("hasRole('ROLE_ADMIN') or filterObject.ownerId == authentication.name")
    public List<Record> findAllRecords() {
        // perform query to get all records.
        List<Record> records = new ArrayList<>();
        records.add(new Record("1", "owner1"));
        records.add(new Record("2", "owner2"));
        return records;
    }
}

class Record {
    String id;
    String ownerId;

    Record(String id, String ownerId) {
        this.id = id;
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "Record{id='" + id + "', ownerId='" + ownerId + "'}";
    }
}