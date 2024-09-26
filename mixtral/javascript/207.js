<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>

<script>
  let encryptedData = CryptoJS.AES.encrypt('my secret message', 'secret key 123');
  localStorage.setItem("secure_data", JSON.stringify(encryptedData));
</script>