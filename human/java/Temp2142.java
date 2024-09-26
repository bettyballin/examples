import java.util.ArrayList;
import java.util.List;

public class Temp2142 {

    public static void main(String[] args) {
        Temp2142 temp = new Temp2142();
        List<Record> records = temp.findAllRecords();
        for (Record record : records) {
            System.out.println(record);
        }
    }

    @PostFilter("filterObject.ownerId == authentication.name")
    public List<Record> findAllRecords() {
        // Simulate database query
        List<Record> records = new ArrayList<>();
        records.add(new Record("1", "user1"));
        records.add(new Record("2", "user2"));
        records.add(new Record("3", "user1"));
        return records;
    }

    static class Record {
        private String id;
        private String ownerId;

        public Record(String id, String ownerId) {
            this.id = id;
            this.ownerId = ownerId;
        }

        public String getOwnerId() {
            return ownerId;
        }

        @Override
        public String toString() {
            return "Record{id='" + id + "', ownerId='" + ownerId + "'}";
        }
    }
}