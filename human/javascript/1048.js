const forge = require('node-forge');

seed = 'hi';
text = 'KQdciM892XEZXYC+jm4sWsijh/fQ4z/PRlpIHQG/+fM=';

function decrypt(seed, text){
  md = forge.md.sha256.create();
  md.update(seed);
  const key = md.digest().getBytes(32);
  const cypher = forge.util.createBuffer(forge.util.decode64(text), 'raw');
  
  console.log(cypher.toHex());
  
  var decipher = forge.cipher.createDecipher('AES-ECB', key);
  decipher.start();
  decipher.update(cypher);
  const result = decipher.finish(false); 
  if(result){
    const out = decipher.output;
    console.log(out.toHex());
    const dec = forge.util.decodeUtf8(out);
    console.log(dec);
  }else{
    console.log('Bad key.');
  }
}

decrypt(seed, text);