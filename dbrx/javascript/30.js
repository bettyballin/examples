(function() {
  const sjcl = require('sjcl');
  const aesKey = sjcl.random.randomWords(8);
  console.log(aesKey);
})();