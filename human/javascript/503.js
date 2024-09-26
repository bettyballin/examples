html
<!DOCTYPE html>
<html>
<head>
  <title>Executable JavaScript Code</title>
</head>
<body>
  <div id="sample">Sample Text</div>
  <div id="output"></div>
  <div id="affected">Affected Text</div>

  <script>
    var el = document.getElementById('sample'), 
    output = document.getElementById('output'),
    affect = document.getElementById('affected');

    affect.style.backgroundColor = "#369";
    affect.style.color = "#FFF";

    output.innerText+=el.innerHTML;
  </script>
</body>
</html>