import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1925 {
    public static void main(String[] args) {
        // Main method for execution
    }

    public StringBuilder getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        final StringBuilder returnValue = new StringBuilder();
        final byte[] value = rs.getBytes(columnIndex);

        if (value != null) {
            for (byte b : value) {
                returnValue.append((char) b);
            }
        }

        return returnValue;
    }
}