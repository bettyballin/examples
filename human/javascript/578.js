var crypto = require('crypto');

var myHash = function(seed){
    var hash = crypto.createHmac('sha256', seed).update('my message').digest('hex');
    console.log(hash);
}

myHash('my secret seed');