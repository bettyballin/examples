
function EncryptText() {
    var text = document.getElementById('textbox').value;
    // Key and IV should be 128-bit for AES-128, which is 16 bytes.
    // Assuming Key and IV are base64 encoded, we need to decode them as such.
    var Key = CryptoJS.enc.Base64
