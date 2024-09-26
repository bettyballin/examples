<!DOCTYPE html>
<html>
<head>
    <title>Child Page</title>
</head>
<body>
    <script>
        if (window.parent) {
            document.addEventListener('load', function() {
                window.parent.postMessage("child loaded", "/");
            }, false);
        }
    </script>
</body>
</html>