const crypto = require('crypto');
const async = require('async');

var crypto_random_number_range = function (n, cb) {
  //result is a number from 0 a n-1
  //Javascript works with 32 bits for bitwise operations but these are signed (2-complement), so it is good to limit the size of n
  if (n <= 0 || n > 2147483647) {
    return cb("n must be larger than 0 and smaller than 2147483647", null);
  }
  var bits, val;
  async.doWhilst(
    function (cb2) {
      crypto.randomBytes(4, function (err, rbytes) {
        if (err) {
          return cb2(err);
        }
        bits = ((rbytes[3] & 0x7f) << 24) + 
          (rbytes[2] << 16) + (rbytes[1] << 8) + rbytes[0];
        val = bits % n;
        cb2();
      });
    }, function () {
      return (bits - val + (n-1)) < 0;
    }, function (err) {
      if (err) {
        return cb(err, null);
      }
      return cb(null, val);
    }
  );
}

// Test the function
crypto_random_number_range(100, function(err, result) {
  if (err) {
    console.error(err);
  } else {
    console.log(result);
  }
});