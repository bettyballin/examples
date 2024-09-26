public class Temp1692 {
    public static void main(String[] args) {
        CSRFTesterModel model = new CSRFTesterModel();
        model.setParameters(new String[] {"param1=value1&param2=value2"});
        Temp1692 temp = new Temp1692();
        System.out.println(temp.getParametersAsHtmlInput(model, 0, true));
    }

    private String getParametersAsHtmlInput(CSRFTesterModel model, int row, boolean isString) {
        String s = model.getParameters(row);
        String[] parts = s.split("&");
        StringBuffer sb = new StringBuffer();
        if ((s == null) || (s.length() == 0)) {
            if (isString) {
                sb.append("'&lt;input type=\"hidden\" name=\"name\" value=\"value\"/&gt;' \r\n");
            } else {
                sb.append("&lt;input type=\"hidden\" name=\"name\" value=\"value\"/&gt; \r\n");
            }
        } else if (parts.length == 1) {
            String[] pair = parts[0].split("=");
            if (isString) {
                sb.append("'&lt;input type=\"hidden\" name=\"" + pair[0] + "\" value=\"" + pair[1] + "\"/&gt;' \r\n");
            } else {
                sb.append("&lt;input type=\"hidden\" name=\"" + pair[0] + "\" value=\"" + pair[1] + "\"/&gt; \r\n");
            }
        } else {
            for (int i = 0; i < parts.length; i++) {
                String name = parts[i].split("=")[0];
                String value = parts[i].split("=").length == 1 ? "" : parts[i].split("=")[1];
                if (isString) {
                    sb.append("'&lt;input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/&gt;'");
                } else {
                    sb.append("&lt;input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/&gt;");
                }
                if ((i + 1 < parts.length) && (isString)) {
                    sb.append(" + \r\n");
                } else {
                    sb.append("\r\n");
                }
            }
        }
        return sb.toString();
    }
}

class CSRFTesterModel {
    private String[] parameters;

    public String getParameters(int row) {
        return parameters[row];
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }
}