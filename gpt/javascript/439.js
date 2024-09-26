
var forge = require('node-forge');

function decrypt(seed, text) {
  var md = forge.md.sha256.create();
  md.update(seed);
  // For AES-256, the key should be 32 bytes long.
  var key = md.digest().getBytes(32);
  var cypher = forge.util.createBuffer(forge.util.decode64(text), 'raw');
  
  console.log(cypher.toHex());
  
  var decipher = forge.cipher.createDecipher('AES-ECB', key);
  decipher.start();
  decipher.update(cypher);

  // Check if the padding is correct and finish the operation.
  var result = decipher.finish(); // check 'result' for true/false

  if(result)
