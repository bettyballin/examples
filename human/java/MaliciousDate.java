import java.util.ArrayList;
import java.util.List;

class MaliciousDate implements Cloneable {
    private final List<MaliciousDate> dates;

    public MaliciousDate(List<MaliciousDate> dates) {
        this.dates = dates;
    }

    @Override
    public MaliciousDate clone() {
        MaliciousDate other = null;
        try {
            other = (MaliciousDate) super.clone(); // Or new MaliciousDate
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        synchronized (dates) {
            dates.add(other);
        }
        return other; // Or return this;
    }

    public static void main(String[] args) {
        List<MaliciousDate> dateList = new ArrayList<>();
        MaliciousDate original = new MaliciousDate(dateList);
        original.clone();
        System.out.println("Date list size: " + dateList.size());
    }
}