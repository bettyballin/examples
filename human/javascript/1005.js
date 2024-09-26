const message = "(query params from an url w/o the hmac signature)";
const given_signature = "(the given hmac signature extracted from the query params)";
const SECRET = "(my secret key)";

const hexToBuffer = (hex) => {
  const matches = hex.match(/[\da-f]{2}/gi) ?? [];
  const typedArray = new Uint8Array(
    matches.map(function (h) {
      return parseInt(h, 16);
    })
  );
  return typedArray.buffer;
};

const algorithm = { name: "HMAC", hash: "SHA-256" };
const encoder = new TextEncoder();

async function verifySignature() {
  const key = await crypto.subtle.importKey(
    "raw",
    encoder.encode(SECRET),
    algorithm,
    false,
    ["sign", "verify"]
  );

  const result = await crypto.subtle.verify(
    algorithm.name,
    key,
    hexToBuffer(given_signature),
    encoder.encode(message)
  );
  console.log(result);
}

verifySignature();