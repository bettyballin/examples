function H(obj) {
  return Object.keys(obj).sort().reduce((acc, key) => acc + key + ":" + obj[key], "");
}

const input = {
  "username-value": "user",
  "realm-value": "realm",
  "passwd": "password"
};

console.log(H(input));