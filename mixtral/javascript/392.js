const signature = new Uint8Array([/* your signature bytes */]);
const given_signature = "/* your given signature */";
const algorithm = { name: "/* your algorithm name */" };
const key = /* your key */;
const message = "/* your message */";
const encoder = new TextEncoder();

const digest = btoa(String.fromCharCode.apply(null, signature));
// Now the 'digest' should match with given_signature

// For verification
crypto.subtle.verify(
  algorithm.name,
  key,
  base64ToUint8Array(given_signature),
  encoder.encode(message)
).then(verify => console.log(verify))
.catch(err => console.error(err));

function base64ToUint8Array(base64String) {
  const padding = '='.repeat((4 - base64String.length % 4) % 4);
  const b64 = (base64String + padding).replace(/-/g, '+').replace(/_/g, '/');

  return Uint8Array.from(atob(b64), c => c.charCodeAt(0));
}