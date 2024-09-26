public class Temp1126 {
    public static void main(String[] args) {
        String form = "<form method=\"POST\" action=\"uploadOneFile?${_csrf.parameterName}=${_csrf.token}\" enctype=\"multipart/form-data\"></form>";
        System.out.println(form);
    }
}