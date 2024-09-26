
function stringToArrayBuffer(str) {
  var encoder = new TextEncoder(); // encoder for converting string to Uint8Array
  return encoder.encode(str);
}

function generateHash() {
  var value = "mypassword";
  var buffer = stringToArrayBuffer(value); // Convert the string to an ArrayBuffer correctly
  window.crypto.subtle.digest("SHA-1", buffer)
    .then(hashBuffer => {
      // Convert the ArrayBuffer to a hex string
      var hashArray = Array.from(new Uint8Array(hashBuffer)); // Create a byte array
      var hashHex = hashArray.map(b => b.toString(16).padStart(2, '0')).join(''); // Convert bytes to hex string
      document.write(hashHex);
    })
    .catch(err => {
     
