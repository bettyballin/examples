<!DOCTYPE html>
<html>
<head>
  <title>Executable JavaScript Code</title>
</head>
<body>
  <script>
    document.addEventListener("select", function(event) {
      const selectedText = window.getSelection().toString();
      window.getSelection().empty();
      event.target.disabled = true;
      setTimeout(function() {
        event.target.disabled = false;
      }, 100);
    });
  </script>
  <p>Select some text on this page to test the code.</p>
</body>
</html>