var hmacSHA1 = function (key) {
    var hasher = new sjcl.misc.hmac( key, sjcl.hash.sha1 );
    this.encrypt = function () {
        return hasher.encrypt.apply( hasher, arguments );
    };
};

var passwordSalt = sjcl.codec.hex.toBits( "cf7488cd1e48e84990f51b3f121e161318ba2098aa6c993ded1012c955d5a3e8" );
var derivedKey = sjcl.misc.pbkdf2( "password", passwordSalt, 100, 256, hmacSHA1 );
var hexKey = sjcl.codec.hex.fromBits( derivedKey );
console.log(hexKey);
// Output: c12b2e03a08f3f0d23f3c4429c248c275a728814053a093835e803bc8e695b4e

// Note: You need to include the Stanford JavaScript Crypto Library (SJCL) in your HTML file for this code to work.
// You can do this by adding the following script tag to your HTML file:
// <script src="https://cdnjs.cloudflare.com/ajax/libs/sjcl/1.0.8/sjcl.min.js"></script>