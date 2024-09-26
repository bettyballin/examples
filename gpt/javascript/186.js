
const crypto = require('crypto');
const { v5: uuidv5 } = require('uuid');

// Your namespace and name
const namespace = 'b9cfdb9d-f741-4e1f-89ae-fac6b2a5d740';
const name = 'something';

// Generate SHA1 UUID in JavaScript
function generateSHA1UUID(namespace, name)
