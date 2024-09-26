const ALLOWED_KEYS = new Set(['key1', 'key2']);

function isAllowedKey(key) {
  return typeof key === "string" && ALLOWED_KEYS.has(key);
}

let obj = Object.create(null);
let key = 'key1';
let value = 'some value';

if (isAllowedKey(key)) {
   obj[key] = value;
}

console.log(obj);