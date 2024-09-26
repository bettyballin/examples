<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
</head>
<body>
  <p id="enc"></p>

  <script>
    var salt = CryptoJS.lib.WordArray.create(0); // empty array
    var params = CryptoJS.kdf.OpenSSL.execute('key', 256/32, 128/32, salt);
    var pt = '1';
    var encrypted = CryptoJS.AES.encrypt(pt, params.key, {iv: params.iv});

    document.querySelector("#enc").innerHTML = encrypted.ciphertext.toString();
  </script>
</body>
</html>