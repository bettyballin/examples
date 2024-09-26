import java.util.Date;

public class Temp950 {
    private Date start;
    private Date end;

    public Temp950(Date start, Date end) {
        // Failing defensive copy.
        this.start = (Date) start.clone();
        this.end = (Date) end.clone();

        if (this.start.compareTo(this.end) > 0)
            throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        Date startDate = new Date(System.currentTimeMillis() - 10000); // 10 seconds ago
        Date endDate = new Date(); // now

        Temp950 period = new Temp950(startDate, endDate);
        System.out.println("Period created from " + period.start + " to " + period.end);
    }
}