<!DOCTYPE html>
<html>
<head>
  <title>Caesar Cipher</title>
</head>
<body>
  <textarea id="myTextArea"></textarea>
  <button onclick="c_ciph()">Encrypt</button>
  <textarea id="result" readonly></textarea>

  <script>
    function c_ciph(){
      var x = document.getElementById("myTextArea").value;
      var result = "";

      for (var i = 0, len = x.length; i < len; i++) {
        if (x[i] == x[i].toUpperCase()){
          var a = x[i].charCodeAt(0);
          var e = ((a - 65 + 3) % 26) + 97;
          var c = String.fromCharCode(e);
          result += c.toUpperCase();
        }
        else if (x[i] == x[i].toLowerCase()){
          var a = x[i].charCodeAt(0);
          var e = ((a - 97 + 3) % 26) + 97;
          var c = String.fromCharCode(e);
          result += c;
        }
      }
      document.getElementById('result').value = result;
    }
  </script>
</body>
</html>