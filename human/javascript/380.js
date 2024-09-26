<!DOCTYPE html>
<html>
<head>
  <script src="https://cdn.rawgit.com/CryptoStore/crypto-js/3.1.2/build/rollups/aes.js"></script>
</head>
<body>
  <script>
    var encrypted = CryptoJS.AES.encrypt("1", "secret key");
    var decrypted = CryptoJS.AES.decrypt(encrypted, "secret key");
    document.getElementById("dec").innerHTML = decrypted.toString(CryptoJS.enc.Utf8);
  </script>
  <span id="dec"></span>
</body>
</html>