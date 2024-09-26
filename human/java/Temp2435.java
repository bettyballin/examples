import java.util.ArrayList;
import java.util.List;

public class Temp2435 {

    static class Scheduled {
        String name;
        String time;

        Scheduled(String name, String time) {
            this.name = name;
            this.time = time;
        }

        public String getName() {
            return name;
        }

        public String getTime() {
            return time;
        }
    }

    public static void main(String[] args) {
        List<Scheduled> scheduledList = new ArrayList<>();
        scheduledList.add(new Scheduled("Event1", "10:00"));
        scheduledList.add(new Scheduled("Event2", "12:00"));
        scheduledList.add(new Scheduled("Event3", "14:00"));

        String x = "09:00";
        String y = "13:00";

        for (Scheduled scheduled : scheduledList) {
            if (scheduled.getTime().compareTo(x) > 0 && scheduled.getTime().compareTo(y) < 0) {
                System.out.println(scheduled.getName());
            }
        }
    }
}