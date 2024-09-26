<!DOCTYPE html>
<html>
<head>
  <title>File Upload Example</title>
</head>
<body>
  <input type="file" id="FileUpload1">
  <script>
    var fil = document.getElementById("FileUpload1");
    fil.addEventListener("change", function() {
      alert(fil.value); // will show file name
    });
  </script>
</body>
</html>