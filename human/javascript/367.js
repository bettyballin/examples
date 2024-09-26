var password = "testpassword";

document.getElementById("enc_button").onclick = function(){
  var text = document.getElementById("new_note").value;
  
  var encrypted = CryptoJS.AES.encrypt(text, password);
  encrypted = encrypted.toString();
  
  var decrypted = CryptoJS.AES.decrypt(encrypted, password);
  decrypted = decrypted.toString(CryptoJS.enc.Utf8)
  
  document.getElementById("decrypted").innerHTML = decrypted;
}

// Added HTML elements to make the code executable
var html = `
  <input type="text" id="new_note" value="Hello, World!">
  <button id="enc_button">Encrypt and Decrypt</button>
  <div id="decrypted"></div>
`;

// Add HTML elements to the page
document.body.innerHTML = html;

// Include CryptoJS library
var script = document.createElement('script');
script.src = "https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js";
document.head.appendChild(script);