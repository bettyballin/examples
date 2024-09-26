
const bcrypt = require('bcrypt');

// Example hash with $2y prefix
const hash = '$2y$10$tRM7x9gGKhcAmpeqKEdhj.qRWCr4qoV1FU9se0Crx2hkMVNL2ktEW';
const password = 'helloworld';

// Replace $2y with $2a
const compatibleHash = hash.replace(/^\
