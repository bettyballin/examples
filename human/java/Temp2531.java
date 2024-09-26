import javax.servlet.http.HttpServletRequest;

public class Temp2531 {

    public static void main(String[] args) {
        // This main method is not typically used in a servlet environment
        // It's here just for formalities
        System.out.println("This is a standalone application entry point, but it won't run servlet code directly.");
    }

    public void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        // This method should be part of a servlet and called by the servlet container
        try {
            if (request.getRequestURL().toString().equals("http://someurl")) {
                //do your stuff
                response.getWriter().println("URL matched!");
            } else {
                response.getWriter().println("URL did not match.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}