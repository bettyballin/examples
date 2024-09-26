public class Temp297 {
    public static void main(String[] args) {
        String script = "<script>\n" +
                "document.addEventListener(\"DOMContentLoaded\", function() {\n" +
                "    var loginForm = document.getElementById(\"loginForm\");\n" +
                "    loginForm.onsubmit = function(event) {\n" +
                "        event.preventDefault();\n" +
                "        var username = document.getElementById(\"username\").value;\n" +
                "        var password = document.getElementById(\"password\").value;\n" +
                "\n" +
                "        var xhr = new XMLHttpRequest();\n" +
                "        xhr.open(\"POST\", \"j_security_check\", true);\n" +
                "        xhr.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n" +
                "        xhr.onreadystatechange = function() {\n" +
                "            if (xhr.readyState === 4 && xhr.status === 200) {\n" +
                "                // Handle successful login\n" +
                "            } else if (xhr.readyState === 4) {\n" +
                "                // Handle login failure\n" +
                "            }\n" +
                "        };\n" +
                "        xhr.send(\"j_username=\" + encodeURIComponent(username) + \"&j_password=\" + encodeURIComponent(password));\n" +
                "    };\n" +
                "});\n" +
                "</script>";

        System.out.println(script);
    }
}