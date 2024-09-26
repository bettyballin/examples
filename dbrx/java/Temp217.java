import java.util.Date;

public class Temp217 {
    private static class Period {
        private final Date start;
        private final Date end;

        public Period(final Date start, final Date end) {
            synchronized (this) { 
                if (start.compareTo(end) > 0) {
                    throw new IllegalArgumentException("Start date must be before end date");
                }
                this.start = new Date(start.getTime());
                this.end = new Date(end.getTime());
            }
        }

        public Date getStart() {
            return new Date(start.getTime());
        }

        public Date getEnd() {
            return new Date(end.getTime());
        }
    }

    public static void main(String[] args) {
        Date startDate = new Date();
        Date endDate = new Date(startDate.getTime() + 1000); // end date is 1 second after start date

        Period period = new Period(startDate, endDate);
        System.out.println("Period start: " + period.getStart());
        System.out.println("Period end: " + period.getEnd());
    }
}