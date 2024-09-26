import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class MaliciousDate extends Date {
    private final List<MaliciousDate> dates;

    public MaliciousDate(List<MaliciousDate> dates) {
        this.dates = dates;
        this.dates.add(this);
    }

    public void setYear(int year) {
        super.setYear(year);
        for (MaliciousDate date : dates) {
            if (!date.equals(this)) {
                date.setYear(year);
            }
        }
    }
}

class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException(start + " after " + end);
    }
}

public class Main40 {
    public static void main(String[] args) {
        List<MaliciousDate> dates = new ArrayList<>();
        MaliciousDate start = new MaliciousDate(dates);
        MaliciousDate end = new MaliciousDate(dates);
        Period p = new Period(start, end);
        dates.get(1).setYear(78);
    }
}