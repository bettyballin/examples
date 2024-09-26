const bcrypt = require('bcrypt');

// Given salt and hash
const salt = "$2a$10$k/a9i/zMGnzx5VKjmhXySO";
const hash = "$2a$10$k/a9i/zMGnzx5VKjmhXySO.sx6fcIPsdbej1pVVcKLy9TbNK.2aLm";

// Create a hash with the given salt
const plaintext = "mysecretpassword";
const newHash = bcrypt.hashSync(plaintext, salt);

// Compare the new hash with the given hash
const compare = bcrypt.compareSync(plaintext, hash);

console.log("Generated Hash:", newHash);
console.log("Comparison Result:", compare);