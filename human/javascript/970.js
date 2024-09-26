const rawToken = `eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWUsImlhdCI6MTUxNjIzOTAyMn0.NHVaYe26MbtOYhSKkoKYdFVomg4i8ZJd8_-RU8VNbftc4TSMb4bXP3l3YlNWACwyXPGffz5aXHc6lty1Y2t4SWRqGteragsVdZufDn5BlnJl9pdR_kdVFUsra2rWKEofkZeIC4yWytE58sMIihvo9H1ScmmVwBcQP6XETqYd0aSHp1gOa9RdUPDvoXQ5oqygTqVtxaDr6wUFKrKItgBMzWIdNZ6y7O9E0DhEPTbE9rfBo6KTFsHAZnMg4k68CDp2woYIaXbmYTWcvbzIuHO7_37GT79XdIwkm95QJ7hYC9RiwrV7mesbY4PAahERJawntho0my942XheVLmGwLMBkQ`;

const [encodedHeaders, encodedClaims, signature] = rawToken.split(".");

const matchedKey = {
  "kty": "RSA",
  "e": "AQAB",
  "kid": "fa05e6ef-ec59-45b4-ba43-51b8293f7f79",
  "n": "u1SU1LfVLPHCozMxH2Mo4lgOEePzNm0tRgeLezV6ffAt0gunVTLw7onLRnrq0_IzW7yWR7QkrmBL7jTKEn5u-qKhbwKfBstIs-bMY2Zkp18gnTxKLxoS2tFczGkPLPgizskuemMghRniWaoLcyehkd3qqGElvW_VDL5AaWTg0nLVkjRo9z-40RQzuVaE8AkAFmxZzow3x-VJYKdjykkJ0iT9wCS0DRTXu269V264Vf_3jvredZiKRkgwlL9xNAwxXFg0x_XFw005UWVRIkdgcKWTjpBP2dPwVZ4WWC-9aGVd-Gyn1o0CLelf4rEjGoXbAAEgAqeGUxrcIlbjXfbcmw"
};

(async () => {
  const pubkey = await crypto.subtle.importKey(
    "jwk",
    matchedKey,
    { name: "RSASSA-PKCS1-v1_5", hash: { name: "SHA-256" } },
    true,
    ["verify"],
  );

  // verify the signature
  const verified = await crypto.subtle.verify(
    { name: "RSASSA-PKCS1-v1_5", hash: { name: "SHA-256" } },
    pubkey,
    new Uint8Array(base64url_decode(signature)),
    new TextEncoder().encode(encodedHeaders + "." + encodedClaims),
  );

  console.log("Verification: ", verified);
})();

// Helper for Base64url encoding, from: https://thewoods.blog/base64url/
function base64url_decode(value) {
  const m = value.length % 4;
  return atob(
    value.replace(/-/g, '+')
      .replace(/_/g, '/')
      .padEnd(value.length + (m === 0 ? 0 : 4 - m), '=')
  ).split('').map(c => c.charCodeAt(0));
}