<!DOCTYPE html>
<html>
<head>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js"></script>
</head>
<body>
  <input type="file" id="file">
  <input type="radio" id="encrypt" name="action" value="encrypt">
  <label for="encrypt">Encrypt</label>
  <input type="radio" id="decrypt" name="action" value="decrypt">
  <label for="decrypt">Decrypt</label>
  <script>
    const fileInput = document.getElementById('file');
    const password = 'your-password';

    fileInput.addEventListener('change', () => {
      const file = fileInput.files[0];

      // Read the contents of the selected file as a binary string
      const reader = new FileReader();
      reader.onloadend = function() {
        const content = reader.result;

        // Encrypt/decrypt using AES algorithm with CryptoJS library
        let encrypted;
        if (document.getElementById('encrypt').checked) {
          encrypted = CryptoJS.AES.encrypt(content, password).toString();
        } else {
          try {
            encrypted = CryptoJS.AES.decrypt(content, password).toString(CryptoJS.enc.Utf8);
          } catch(e) {
            alert("Invalid Password");
            return;
          }
        }

        // Create a new Blob object with the decrypted/encrypted content
        const blob = new Blob([new Uint8Array(encrypted.length)], {type: 'application/octet-stream'});

        // Download the file using an anchor tag and URL.createObjectURL()
        const url = window.URL.createObjectURL(blob);
        const link = document.createElement('a');
        link.href = url;
        if (document.getElementById('encrypt').checked) {
          link.download = `encrypted-${file.name}`;
        } else {
          link.download = `decrypted-${file.name}`;
        }
        link.click();
      };

      reader.readAsBinaryString(file);
    });
  </script>
</body>
</html>