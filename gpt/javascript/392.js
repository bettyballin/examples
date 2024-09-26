
async function generateSHA256Base64Hash(script) {
    // Encode the string as a Uint8Array
    const buffer = new TextEncoder().encode(script);
    
    // Hash the buffer using SHA-256
    const hashArrayBuffer = await crypto.subtle.digest('SHA-256', buffer);
    
    // Convert the hash to a byte array
    const byteArray = new Uint8Array(hashArrayBuffer);
    
    // Convert the byte array to a Base64 string
    const base64String = btoa(String.fromCharCode.apply(null, byteArray));
    
    return 'sha256-' + base64String;
}

// Your script string
const string = `
//
var theForm = document.forms['ctl00'];
...
//
`;

// Generate the hash and log it to the console
generateSHA256Base64Hash(string)
    .then(hash => console.log(hash))
    .catch(error => console.error(error));

