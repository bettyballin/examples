const ENCODING = "utf-8";
const PBKDF2SHA1 = { name: "PBKDF2", hash: "SHA-1" };
const HMACSHA1 = { name: "HMAC", hash: "SHA-1" };

async function pbkdf2_generate_key_from_string(string) {
  return crypto.subtle.importKey(
    "raw",
    str2binb(string),
    PBKDF2SHA1,
    false,
    ["deriveBits"]
  );
}

async function pbkdf2_derive_salted_hmac(key, salt, iterations) {
  const derivedKey = await crypto.subtle.deriveBits(
    {
      name: "PBKDF2",
      hash: PBKDF2SHA1.hash,
      salt: new Uint8Array(salt),
      iterations: iterations,
    },
    key,
    160 * 4
  );

  return crypto.subtle.importKey("raw", derivedKey, HMACSHA1, false, ["sign"]);
}

function str2binb(str) {
  const bytes = new Uint8Array(str.length);
  for (let i = 0; i < str.length; i++) {
    bytes[i] = str.charCodeAt(i);
  }
  return bytes;
}

function b64binb(str) {
  return new Uint8Array(atob(str).split("").map((c) => c.charCodeAt(0)));
}

// Usage:
const salt = b64binb("QSXCR+Q6sek8bf92");
pbkdf2_generate_key_from_string("pencil").then((key) => {
  pbkdf2_derive_salted_hmac(key, salt, 4096).then((x) => console.log(x));
});