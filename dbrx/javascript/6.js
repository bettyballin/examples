<!DOCTYPE html>
<html>
<head>
  <title>Executable Code</title>
</head>
<body>
  <div id="myDiv"></div>
  <script>
    const userInput = 'hello world';
    document.getElementById('myDiv').innerHTML = `<div>${JSON.stringify(userInput)}</div>`;
  </script>
</body>
</html>