// Convert base64url encoded strings into ArrayBuffer
const encodedHeaders = "your_base64url_encoded_headers";
const encodedClaims = "your_base64url_encoded_claims";
const decodedHeaders = Uint8Array.from(atob(encodedHeaders.replace(/-/g, '+').replace(/_/g, '/')), c => c.charCodeAt(0));
const decodedClaims = Uint8Array.from(atob(encodedClaims.replace(/-/g, '+').replace(/_/g, '/')), c => c.charCodeAt(0));

// Concatenate headers and claims
let messageBytes = new Uint8Array([...decodedHeaders, 46, ...decodedClaims]);

// Verify the signature
const pubkey = "your_public_key";
const signature = "your_base64url_encoded_signature";
const verified = await crypto.subtle.verify({ name: "RSASSA-PKCS1-v1_5" }, pubkey,
                    messageBytes, new Uint8Array(atob(signature.replace(/-/g, '+').replace(/_/g, '/')).split('').map(c => c.charCodeAt(0))));