public class Temp1501 {
    public static void main(String[] args) {
        System.out.println(getHtmlContent());
    }

    public static String getHtmlContent() {
        return "<ui:define name=\"content\">" +
                "<pm:content styleClass=\"content\">" +
                "<h:form>" +
                "<pm:field>" +
                "<h:outputLabel for=\"username\" value=\"Username\" />" +
                "<h:inputText id=\"username\" value=\"#{authenticationBean.username}\" required=\"true\" />" +
                "<h:message for=\"username\" />" +
                "</pm:field>" +
                "<pm:field>" +
                "<h:outputLabel for=\"password\" value=\"Password\" />" +
                "<h:inputSecret id=\"password\" value=\"#{authenticationBean.password}\" required=\"true\" />" +
                "<h:message for=\"password\" />" +
                "</pm:field>" +
                "<pm:field>" +
                "<h:commandButton value=\"Login\" action=\"#{authenticationBean.login()}\" />" +
                "</pm:field>" +
                "</h:form>" +
                "</pm:content>" +
                "</ui:define>";
    }
}