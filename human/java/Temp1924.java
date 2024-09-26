import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1924 {
    public static void main(String[] args) {
        // Placeholder main method
    }

    public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getString(columnIndex);
    }
}