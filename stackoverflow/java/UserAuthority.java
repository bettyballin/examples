public enum UserAuthority {
    BOOK_READ("BOOK_READ", "ROLE_BOOK_READ"),
    BOOK_UPD("BOOK_UPD", "ROLE_BOOK_UPD");
    // more enums

    private final String columnName;
    private final String roleName;

    UserAuthority(String columnName, String roleName) {
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