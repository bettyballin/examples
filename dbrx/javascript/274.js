Here is the executable JavaScript code:


export function b642ab(base64_string){
  return Uint8Array.from(atob(base64_string), c => c.charCodeAt(0));
}

async function verifySignature(signature, public_key, data_in) {
  // Sorting alphabetically to avoid signature mismatch with BE
  const sorted_data_in = sortObjKeysAlphabetically(data_in);

  var dataStr = JSON.stringify(sorted_data_in)
  console.log(dataStr)

  var dataBuf = new TextEncoder().encode(dataStr)

  return window.crypto.subtle.verify(
    {
      name: "ECDSA",
      namedCurve: "P-256",
      hash: {name: "SHA-256"}
    },
    public_key,
    b642ab(signature),
    dataBuf
  );
}

// Helper function to sort object keys alphabetically
function sortObjKeysAlphabetically(obj) {
  return Object.keys(obj).sort().reduce((result, key) => {
    result[key] = obj[key];
    return result;
  }, {});
}

// Example usage
const public_key = "your_public_key_here";
const private_dsa_key = "your_private_dsa_key_here";
const generated_payload = "your_generated_payload_here";

const sign = async (payload, private_key) => {
  const signature = await window.crypto.subtle.sign(
    {
      name: "ECDSA",
      namedCurve: "P-256",
      hash: {name: "SHA-256"}
    },
    private_key,
    new TextEncoder().encode(payload)
  );
  return btoa(String.fromCharCode(...new Uint8Array(signature)));
};

const sign_payload = async (private_dsa_key, generated_payload) => {
  const signature = await sign(generated_payload, private_dsa_key);
  return signature;
};

const verify = async () => {
  const signature = await sign_payload(private_dsa_key, generated_payload);
  const decoded_signature = atob(signature);
  const sorted_data_in = sortObjKeysAlphabetically({ /* your data object here */ });
  await verifySignature(decoded_signature, public_key, sorted_data_in);
};

verify();