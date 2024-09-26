import java.util.List;
import java.util.ArrayList;

public class Temp283 {

    private List<Local> userLocaleList;

    public Temp283() {
        this.userLocaleList = new ArrayList<>();
    }

    public List<Local> getUserLocales() {
        return this.userLocaleList;
    }

    public static void main(String[] args) {
        Temp283 temp = new Temp283();
        System.out.println(temp.getUserLocales());
    }
}

class Local {
    // Define Local class properties and methods here.
}