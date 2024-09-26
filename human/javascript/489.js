<!DOCTYPE html>
<html>
<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/components/core-min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/aes.js"></script>

<script>
  data = "mdnLCY6MdwEONY1AxR/vjVKMssB+yrPsz4QMjfl6fDXxv68E0EUxtAqa4VUo\nfTkjq2Hqyd48UV3dyWmEbwXw5Q==\n";
  key = "2e35f242a46d67eeb74aabc37d5e5d05";

  var rawData = atob(data);
  var iv = rawData.substring(0,16);
  var crypttext = rawData.substring(16);

  // Decrypt...
  var plaintextArray = CryptoJS.AES.decrypt(
    { ciphertext: CryptoJS.enc.Latin1.parse(crypttext) },
    CryptoJS.enc.Hex.parse(key),
    { iv: CryptoJS.enc.Latin1.parse(iv) }
  );

  console.log(plaintextArray);
  console.log(CryptoJS.enc.Latin1.stringify(plaintextArray));
</script>
</head>
<body>
</body>
</html>