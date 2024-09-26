<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>SHA-1 Hash Generator</title>
</head>
<body>
  <script>
    function generateHash() {
      var value = "mypassword";

      // Convert string to Uint8Array
      let encoder = new TextEncoder();
      let uint8array_value = encoder.encode(value);

      window.crypto.subtle
        .digest("SHA-1", uint8array_value)
        .then((hashBuffer) => {
          // Convert ArrayBuffer to hexadecimal string
          var hashArray = Array.from(new Uint8Array(hashBuffer));

          let result = hashArray
            .map((b) => b.toString(16).padStart(2, "0"))
            .join("");

          document.write("SHA-1: " + result);
        })
    }

    generateHash();
  </script>
</body>
</html>