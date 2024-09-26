public class Temp1368 {
    public static void main(String[] args) {
        String inputHtml = "<form:input name=\"uploadBanner\" type=\"file\" id=\"uploadBanner\" path=\"bannerImage\"/>";
        String outputHtml = inputHtml.replace("<form:input", "<input").replace("/>", "/>");
        System.out.println(outputHtml);
    }
}