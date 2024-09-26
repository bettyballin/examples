Here is the executable code:

html
<!DOCTYPE html>
<html>
<head>
  <title>Encrypt/Decrypt File</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.1.1/crypto-js.min.js" integrity="sha512-E8QSvWZ0eCLGk4km3hxSsNmGWbLtSCSUcewDQPQWZF6pEU8GlT8a5fF32wOl1i8ftdMhssTrF/OhyGWwonTcXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
</head>
<body>
  <div>
    <h1>encrypt/decrypt file</h1>
    <ol>
      <li>Set password</li>
      <li>Pick a file</li>
      <li>Download decrypted/encrypted file</li>
    </ol>
    <div>
      <input type="text" id="pass" placeholder="pass">
      <button id="encrypt">encrypt file</button>
      <button id="decrypt">decrypt file</button>
      <button id="test">test</button>
    </div>
  </div>

  <script>
    // support
    const download = (data, filename, type) => {
      const file = new Blob([data], {
        type: type
      });
      const a = document.createElement('a');
      const url = URL.createObjectURL(file);

      a.href = url;
      a.download = filename;
      document.body.appendChild(a);

      a.click();

      setTimeout(function() {
        document.body.removeChild(a);
        window.URL.revokeObjectURL(url);
      }, 0);
    };
    const pickAFile = (getText = true) => {
      return new Promise((resolve, reject) => {
        const input = document.createElement('input');
        input.type = 'file';
        input.onchange = (e) => {
          const file = e.target.files[0];
          const reader = new FileReader();
          if (!getText) {
            resolve(file);
          } else {
            reader.onload = (e) => resolve(e.target.result);
            reader.onerror = (e) => reject(e);
            reader.readAsText(file);
          }
        };
        input.click();
      });
    };
    const convertWordArrayToUint8Array = (wordArray) => {
      const arrayOfWords = wordArray.hasOwnProperty('words') ? wordArray.words : [];

      const length = wordArray.hasOwnProperty('sigBytes') ?
        wordArray.sigBytes :
        arrayOfWords.length * 4;

      const uInt8Array = new Uint8Array(length);
      let index = 0;
      let word;
      let i;

      for (i = 0; i < length; i++) {
        word = arrayOfWords[i];
        uInt8Array[index++] = word >> 24;
        uInt8Array[index++] = (word >> 16) & 0xff;
        uInt8Array[index++] = (word >> 8) & 0xff;
        uInt8Array[index++] = word & 0xff;
      }
      return uInt8Array;
    };
    // /support

    function app() {
      const passNode = document.querySelector('input#pass');
      const encryptNode = document.querySelector('#encrypt');
      const decryptNode = document.querySelector('#decrypt');

      encryptNode.addEventListener('click', () => {
        if (!passNode.value) return alert('Password input is empty! Aborting.');
        const key = CryptoJS.SHA256(passNode.value); // Fix 1: Derive 32 bytes key
        pickAFile(false).then((file) => {
          const reader = new FileReader();

          reader.onload = (e) => {
            const iv = CryptoJS.lib.WordArray.random(16); // Fix 2: Create random 16 bytes IV
            const wordArray = CryptoJS.lib.WordArray.create(e.target.result);
            const encrypted = CryptoJS.AES.encrypt(wordArray, key, {iv: iv}); // Fix 3: Encrypt with AES using the above key and IV
            const ivCiphertext = iv.clone().concat(encrypted.ciphertext).toString(CryptoJS.enc.Base64); // Fix 4: Concatenate IV and ciphertext
            download(ivCiphertext, `encrypted-${file.name}`, file.type);
          };

          reader.readAsArrayBuffer(file);
        });
      });

      decryptNode.addEventListener('click', () => {
        if (!passNode.value) return alert('Password input is empty! Aborting.');
        const key = CryptoJS.SHA256(passNode.value); // Fix 5: Derive 32 bytes key
        pickAFile(false).then((file) => {
          const reader = new FileReader();

          reader.onload = (e) => {
            try {
              const ivCiphertext = CryptoJS.enc.Base64.parse(e.target.result); // Fix 6: Separate IV and ciphertext
              const iv = CryptoJS.lib.WordArray.create(ivCiphertext.words.slice(0, 4)); 
              const ciphertext = CryptoJS.lib.WordArray.create(ivCiphertext.words.slice(4)); 
              const decrypted = CryptoJS.AES.decrypt({ciphertext: ciphertext}, key, {iv: iv}); // Fix 7: Decrypt
              const typedArray = convertWordArrayToUint8Array(decrypted);
              download(typedArray, `decrypted-${file.name}`, file.type);
            } catch (error) {
              console.log('wrong password!');
            }
          };

          reader.readAsText(file);
        });
      });
    }

    if (document.readyState === 'loading') {
      document.addEventListener('DOMContentLoaded', app);
    } else {
      app();
    }
  </script>
</body>
</html>