const crypto = require('crypto');
const jsonCanonicalize = require('json-canonicalize');

const inputJson = '{"name": "John", "age": 30, "city": "New York"}';
const inputJson2 = '{"age": 30, "city": "New York", "name": "John"}';

const hash1 = crypto.createHash('sha256');
const hash2 = crypto.createHash('sha256');

hash1.update(jsonCanonicalize(inputJson));
hash2.update(jsonCanonicalize(inputJson2));

const hashValue1 = hash1.digest('hex');
const hashValue2 = hash2.digest('hex');

console.log(hashValue1);
console.log(hashValue2);