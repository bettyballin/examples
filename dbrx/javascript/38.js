<!DOCTYPE html>
<html>
<head>
  <title>Reversed URL</title>
</head>
<body>
  <a id="myLink">Click me!</a>
  <script>
    let reversedUrl = "egakcap gnitirw si ssiht taerg";
    document.getElementById("myLink").href = Array.from(reversedUrl).reverse().join("");
  </script>
</body>
</html>