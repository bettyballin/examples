import java.util.List;

class MaliciousDate implements Cloneable {
    private final List<MaliciousDate> dates;

    public MaliciousDate(List<MaliciousDate> dates) {
        this.dates = dates;
    }

    @Override
    public MaliciousDate clone1() {
        try {
            MaliciousDate other = (MaliciousDate)super.clone1();
            synchronized (dates) {
                dates.add(other);
            }
            return other;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should not happen since we are Cloneable
        }
    }
}