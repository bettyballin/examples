const crypto = require('crypto');

var codes = [];
for(let i = 0;i < 100;i++){
    (function(i){
        while(codes[i] === undefined) {
            try{
                let buf = crypto.randomBytes(256);
                codes[i] = buf.toString('hex');
            } catch(ex) {}
         }
    })(i);
}

console.log(codes);