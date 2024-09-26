const BASE_64_KEY = "your_base64_key_here";
const key_in_bytes = Buffer.from(BASE_64_KEY, 'base64');
console.log(key_in_bytes);