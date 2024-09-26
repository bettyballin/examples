function doSign() {
  var rsa = new RSAKey();
  rsa.readPrivateKeyFromPEMString(document.form1.prvkey1.value); //replace with your private key
  var hSig = rsa.signString("x", "sha1");
  var base64_encoded_signature = hex2b64(hSig);
  console.log(base64_encoded_signature);
}

// Define the RSAKey class
class RSAKey {
  readPrivateKeyFromPEMString(pem) {
    // Implementation to read private key from PEM string
    // You need to implement this method or use a library like forge.js
  }

  signString(string, algorithm) {
    // Implementation to sign a string using the private key
    // You need to implement this method or use a library like forge.js
  }
}

// Define the hex2b64 function
function hex2b64(h) {
  return btoa(String.fromCharCode.apply(null, h.match(/../g).map(function(a){return parseInt(a,16)})));
}

// Create a form and textarea to input the private key
var form = document.createElement('form');
form.name = 'form1';

var textarea = document.createElement('textarea');
textarea.name = 'prvkey1';
form.appendChild(textarea);

document.body.appendChild(form);

// Call the doSign function when the form is submitted
form.onsubmit = function(event) {
  event.preventDefault();
  doSign();
}