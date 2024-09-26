<script src="https://cdn.rawgit.com/CryptoStore/crypto-js/3.1.2/build/rollups/aes.js"></script>

<script>
  var encrypted = CryptoJS.AES.encrypt("Message", "Secret Passphrase");
  document.getElementById("enc").innerHTML = encrypted.toString();
</script>

<span id="enc"></span>