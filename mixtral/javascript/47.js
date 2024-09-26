Here is the executable JavaScript code:


const crypto = require('crypto');
const io = require('socket.io')();

// Generate a secret key
let SECRET_KEY = 'my-secret';

function decrypt(data) {
  let decipher = crypto.createDecipher('aes192', SECRET_KEY);
  return JSON.parse(decipher.update(data, 'hex', 'utf8') +
         decipher.final('utf8'));
}

io.on('connection', function (socket) {
    socket.emit("news", {
        hello: "world"
    });

   // Decrypt and validate the data
  socket.on("my other event", function(data, encryptedData){
      let decrypted = decrypt(encryptedData);

     if (decrypted &&
         typeof decrypted === 'object' &&
         "latitude" in decrypted) {
         console.log(decrypted);
     }
  });
});

io.listen(3000, function () {
  console.log('Server listening on port 3000');
});