public class Temp1318 {
    public static void main(String[] args) {
        // Simulating exceptions by throwing them
        try {
            throw new IllegalArgumentException("'dataSource' or 'jdbcTemplate' is required");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        try {
            throw new IllegalStateException("DataSource must be set");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}