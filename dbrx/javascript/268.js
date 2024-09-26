const encodedHeaders = "your_encoded_headers_here";
const encodedClaims = "your_encoded_claims_here";

const message = new TextEncoder().encode(encodedHeaders + "." + encodedClaims);

console.log(message);