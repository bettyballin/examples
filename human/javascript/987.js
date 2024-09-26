<html>
  <body>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
    <p style="font-family:'Courier New', monospace;" id="hmac"></p>
    <p style="font-family:'Courier New', monospace;" id="hmacDir"></p>

    <script>
      var message = "Hello, World!";
      var key = "secretkey";
      var hash = CryptoJS.HmacSHA256(message, key);
      var hmac = hash.toString(CryptoJS.enc.Hex);

      document.getElementById("hmac").innerHTML = hmac;

      var hashDir = CryptoJS.HmacSHA256(message, key, { asBytes: true });
      var hmacDir = hashDir.toString(CryptoJS.enc.Hex);

      document.getElementById("hmacDir").innerHTML = hmacDir;
    </script>
  </body>
</html>