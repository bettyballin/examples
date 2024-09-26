package project.src.main.webapp.restricted;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class InfoBean {
    private String info;

    public InfoBean() {
        info = "This is restricted information.";
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}


xml
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://java.sun.com/jsf/html"
      xmlns:f="http://java.sun.com/jsf/core">
<h:head>
    <title>Restricted Information</title>
</h:head>
<h:body>
    <h:form>
        <h:outputLabel value="Info: " />
        <h:outputText value="#{infoBean.info}" />
    </h:form>
</h:body>
</html>