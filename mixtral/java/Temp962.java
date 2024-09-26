import java.sql.*;
import java.util.*;

public class Temp962 {
    public static void main(String[] args) {
        // Example usage
        List<String> exampleList = Arrays.asList("value1", "value2", "value3");
        try {
            List<Map<String, Object>> result = new Temp962().parameterize(exampleList);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> parameterize(List<?> list) throws IllegalArgumentException {
        List<Map<String, Object>> results = new ArrayList<>();
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be null or empty");
        }

        String b = "SELECT * FROM table_name WHERE abc IN (" + createPlaceholders(list.size()) + ")";
        try (Connection conn = getJdbcTemplate().getDataSource().getConnection(); 
             PreparedStatement ps = conn.prepareStatement(b)) {
            for (int i = 0; i < list.size(); i++) {
                // Assuming all elements in the list are of same type
                Object value = list.get(i);

                if (value instanceof String) {
                    ps.setString(i + 1, (String) value);
                } else if (value instanceof Integer) {
                    ps.setInt(i + 1, (Integer) value);
                } else if (value instanceof Double) {
                    ps.setDouble(i + 1, (Double) value);
                } else if (value instanceof Boolean) {
                    ps.setBoolean(i + 1, (Boolean) value);
                } else {
                    throw new IllegalArgumentException("Unsupported data type: " + value.getClass().getName());
                }
            }

            ResultSet rs = ps.executeQuery();

            // Process result set and return the results
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                results.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return results;
    }

    private static String createPlaceholders(int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append("?");
        }

        return sb.toString();
    }

    // Mock method to simulate JdbcTemplate
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate();
    }

    // Mock JdbcTemplate class
    public class JdbcTemplate {
        public DataSource getDataSource() {
            return new DataSource();
        }
    }

    // Mock DataSource class
    public class DataSource {
        public Connection getConnection() throws SQLException {
            // Return a mock connection or a real one in actual implementation
            return DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", "");
        }
    }
}