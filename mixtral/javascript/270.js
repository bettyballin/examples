const btoa = require('btoa');

// Convert base64url key format (used in browser's crypto) to regular Base64
let urlSafeKey = '9ffC8m6BhFFf0mYTPrf5SAzDVCAGg1ce59LP5dqGnVc';
const paddingSize = 3 - ((urlSafeKey.length + 3) % 4);
if (paddingSize < 3 && urlSafeKey[urlSafeKey.length-1] === '=') {
    throw new Error('Invalid key length');
}
let base64key = [
   urlSafeKey.slice(0, urlSafeKey.length - paddingSize),
   paddingSize === 2 ? '==' : paddingSize === 1 ? '=' : '',
   urlSafeKey.replace(/-/g, '+').replace(/_/g, '/')
].join("");

// Decode Base64 to Buffer
const decodedKey = Buffer.from(base64key, 'base64');

console.log(decodedKey);