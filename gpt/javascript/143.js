
const crypto = require('crypto');

var array = new Uint32Array(10);
crypto.randomFill(array, (err, arr) => {
  if(err) throw err;
  console.log(arr);
});

