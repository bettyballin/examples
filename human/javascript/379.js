<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
</head>
<body>
  <p id="dec"></p>

  <script>
    var ctHex = '83684beb6c8cf063caf45cb7fad04a50';
    var ct = CryptoJS.enc.Hex.parse(ctHex);
    var salt = CryptoJS.lib.WordArray.create(0); // empty array
    var decrypted = CryptoJS.AES.decrypt({ciphertext: ct, salt: salt}, 'key');

    document.querySelector("#dec").innerHTML = decrypted.toString(CryptoJS.enc.Utf8);
  </script>
</body>
</html>