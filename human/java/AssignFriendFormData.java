public class AssignFriendFormData {
    private String friendId;
    private String customerId;

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public static void main(String[] args) {
        AssignFriendFormData data = new AssignFriendFormData();
        data.setFriendId("F123");
        data.setCustomerId("C456");

        System.out.println("Friend ID: " + data.getFriendId());
        System.out.println("Customer ID: " + data.getCustomerId());
    }
}