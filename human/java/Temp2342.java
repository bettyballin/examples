public class Temp2342 {
    public static void main(String[] args) {
        for (User_Authority authority : User_Authority.values()) {
            System.out.println("Authority: " + authority.getColumnName() + ", Role: " + authority.getRoleName());
        }
    }

    public enum User_Authority {
        BOOK_READ("BOOK_READ", "ROLE_BOOK_READ"),
        BOOK_UPD("BOOK_UPD", "ROLE_BOOK_UPD");
        // more enums

        private final String columnName;
        private final String roleName;

        User_Authority(String columnName, String roleName) {
            this.columnName = columnName;
            this.roleName = roleName;
        }

        public String getColumnName() {
            return columnName;
        }

        public String getRoleName() {
            return roleName;
        }
    }
}