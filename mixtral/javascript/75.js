const crypto = require('crypto');

// Generate secret key
let privateKey = 'mysecretkey';

// Website A
function createToken(params){
    let tokenData = JSON.stringify({
        param1 : params[0],
        param2:  params[1]
     });

   // Create a cipher using the secret key
   const cipher = crypto.createCipher('aes-256-cbc', privateKey);

    let encryptedToken = Buffer.concat([
      cipher.update(tokenData),
      cipher.final()
    ]);

  return encryptedToken;
}

// Website B
function verifyAndDecrypt(encryptedToken){
   // Create a decipher using the secret key
    const decipher = crypto.createDecipher('aes-256-cbc', privateKey);

     let tokenData = Buffer.concat([
      decipher.update(encryptedToken),
      decipher.final()
  ]);

  // Parse and verify the data
    try{
        var parsedData = JSON.parse(tokenData.toString());

       if (parsedData &&
           typeof parsedData === 'object' &&
           "param1" in parsedData &&
           "param2" in parsedData){

          return true;
         }
    } catch (err) {
        console.error(err);
        return false;
     }
}

// Test the functions
let params = ['value1', 'value2'];
let encryptedToken = createToken(params);
console.log(verifyAndDecrypt(encryptedToken));