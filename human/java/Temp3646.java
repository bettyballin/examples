public class MyActionClass {
    private boolean cspDisabled;

    public boolean isCspDisabled() {
        return cspDisabled;
    }

    public void setCspDisabled(boolean cspDisabled) {
        this.cspDisabled = cspDisabled;
    }

    public String execute() {
        // Your action logic here
        if (cspDisabled) {
            System.out.println("CSP is disabled");
        } else {
            System.out.println("CSP is enabled");
        }
        return "success";
    }

    public static void main(String[] args) {
        MyActionClass action = new MyActionClass();
        action.setCspDisabled(true); // Setting CSP disabled for testing
        action.execute();
    }
}