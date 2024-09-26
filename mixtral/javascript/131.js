const bcrypt = require('bcryptjs');

var yToAHash = '$2y$10$tRM7x9gGKhcAmpeqKEdhj.qRWCr4qoV1FU9se0Crx2hkMVNL2ktEW'.replace('$2y', '$2a');
bcrypt.compare('string', yToAHash)
  .then((result) => {
    console.log("Result: " + result);
});