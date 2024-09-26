import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Temp951 {
    public static void main(String[] args) {
        List<MaliciousDate> dates = new ArrayList<>();
        Date start = new MaliciousDate(dates);
        Date end = new MaliciousDate(dates);
        Period p = new Period(start, end);
        dates.add((MaliciousDate) start);
        dates.add((MaliciousDate) end);
        dates.get(1).setYear(78); // Modifies internals of p!
    }
}

class MaliciousDate extends Date {
    private final List<MaliciousDate> dates;

    public MaliciousDate(List<MaliciousDate> dates) {
        this.dates = dates;
    }

    @Override
    public void setYear(int year) {
        super.setYear(year);
        for (MaliciousDate date : dates) {
            date.setYear(year);
        }
    }
}

class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}