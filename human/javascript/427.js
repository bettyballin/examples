<!DOCTYPE html>
<html>
<head>
    <title>Executable Code</title>
</head>
<body>
    <div id="response"></div>
    <script>
        var xmlHTTP = new XMLHttpRequest();
        xmlHTTP.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                document.getElementById('response').appendChild(
                    document.createTextNode(
                        this.responseText
                    )
                );
            }
        };
        xmlHTTP.open("GET", "https://jsonplaceholder.typicode.com/todos/1", true);
        xmlHTTP.send();
    </script>
</body>
</html>