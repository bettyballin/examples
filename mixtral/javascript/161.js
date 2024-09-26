<!DOCTYPE html>
<html>
<head>
    <title>Clone Node Example</title>
</head>
<body>
    <div id="original">This is the original element.</div>
    <div id="copy"></div>

    <script>
        var originalElement = document.getElementById('original');
        var copyElement = originalElement.cloneNode(true);
        document.getElementById('copy').appendChild(copyElement);
    </script>
</body>
</html>