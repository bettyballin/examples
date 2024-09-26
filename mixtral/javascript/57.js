const crypto = require('crypto');

var codes = [];
for(let i = 0;i < 100;i++){
    (function(i){
        crypto.randomBytes(256, function(ex, buf) {
            if (!ex && buf !== undefined)
                codes[i] = buf.toString('hex');
         });
     })(i);
}

// To print the codes array after all randomBytes callbacks have completed
let counter = 0;
for(let i = 0;i < 100;i++){
    (function(i){
        crypto.randomBytes(256, function(ex, buf) {
            if (!ex && buf !== undefined) {
                codes[i] = buf.toString('hex');
                counter++;
                if (counter === 100) {
                    console.log(codes);
                }
            }
         });
     })(i);
}