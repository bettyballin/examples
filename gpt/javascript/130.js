
const bs58 = require('bs58');
const crypto = require('crypto');

function validateDogecoinAddress(address) {
    try {
        let decoded = bs58.decode(address);
        if (decoded.length !== 
