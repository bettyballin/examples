class CustomUser {
    private int userId;

    public CustomUser(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}

interface Authentication {
    Object getPrincipal();
}

class Temp985 {
    public static void main(String[] args) {
        Authentication authentication = new Authentication() {
            @Override
            public Object getPrincipal() {
                return new CustomUser(12345);
            }
        };

        CustomUser customUser = (CustomUser) authentication.getPrincipal();
        int userId = customUser.getUserId();
        System.out.println("User ID: " + userId);
    }
}