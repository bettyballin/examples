const BEGIN = "-----BEGIN PUBLIC KEY-----";
const END = "-----END PUBLIC KEY-----";

function toBase64DER(pem) {
  return pem.replace(/\n/g, "")
            .replace(BEGIN, "")
            .replace(END, "");
}

// Test the function
let pem = `-----BEGIN PUBLIC KEY-----
MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAy8Dbv8prpJmDq//6dH
...
-----END PUBLIC KEY-----`;
console.log(toBase64DER(pem));