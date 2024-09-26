import javax.servlet.Filter;

public class MyFilter extends Filter {
    public MyFilter() {
        super("/login");
    }
}