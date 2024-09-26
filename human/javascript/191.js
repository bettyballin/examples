<!DOCTYPE html>
<html>
<head>
</head>
<body>
<p id="demo">=a</p>
<button type="button" id="do-count">Count</button>
<script>
  document.getElementById("do-count").addEventListener("click", function() {
    var text = document.getElementById("demo").textContent;
    var count = (text.match(/=/g) || []).length;
    document.getElementById("demo").textContent = text + " (Count: " + count + ")";
  });
</script>
</body>
</html>