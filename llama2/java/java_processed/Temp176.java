public class Temp176 {
    public static void main(String[] args) {
        Policy policy = new Policy();
        policy.addCondition(new Condition("creator", "equals", "requester"));
    }
}

class Policy {
    public void addCondition(Condition condition) {
        // Add the condition to the policy
        System.out.println("Condition added: " + condition);
    }
}

class Condition {
    private String attribute;
    private String operator;
    private String value;

    public Condition(String attribute, String operator, String value) {
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Condition{" +
                "attribute='" + attribute + '\'' +
                ", operator='" + operator + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}