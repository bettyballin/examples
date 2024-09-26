Here is the executable JavaScript code:


(async () => {

    var x509pem = `-----BEGIN PUBLIC KEY-----
MFkwEwYHKoZIzj0CAQYIKoZIzj0DAQcDQgAEMpHT+HNKM7zjhx0jZDHyzQlkbLV0
xk0H/TFo6gfT23ish58blPNhYrFI51Q/czvkAwCtLZz/6s1n/M8aA9L1Vg==
-----END PUBLIC KEY-----`
    var public_key = await importPublicKey(x509pem)
    var data_in = {
        key1: "value1",
        key2: "value2"
    }
    var signature = "KIkBK4pxSFq/UdsPb/mYCC3y7iAJlULC/jizNp9DrvFFIvZaUjx/M0SAQC7CeBIlLmKzfkGx1fOr7OJ8VlwAdg=="
    var verified = await verifySignature(signature, public_key, data_in)
    console.log(verified);

})();

function b642ab(base64_string){
    return Uint8Array.from(atob(base64_string), c => c.charCodeAt(0));
}

async function verifySignature(signature, public_key, data_in) {
    // Sorting alphabetically to avoid signature mismatch with BE
    var dataStr = JSON.stringify(data_in)
    console.log(dataStr)

    var dataBuf = new TextEncoder().encode(dataStr)

    return crypto.subtle.verify(
        {
            name: "ECDSA",
            namedCurve: "P-256",
            hash: { name: "SHA-256" },
        },
        public_key,
        b642ab(signature),
        dataBuf
    );
}

async function importPublicKey(spkiPem) {   
    return await crypto.subtle.importKey(
        "spki",
        getSpkiDer(spkiPem),
        {name: "ECDSA", namedCurve: "P-256"},
        false,
        ["verify"]
    );
}

function getSpkiDer(spkiPem){
    const pemHeader = "-----BEGIN PUBLIC KEY-----";
    const pemFooter = "-----END PUBLIC KEY-----";
    var pemContents = spkiPem.substring(pemHeader.length, spkiPem.length - pemFooter.length);
    var binaryDerString = atob(pemContents);
    return str2ab(binaryDerString); 
}

function str2ab(str) {
    const buf = new ArrayBuffer(str.length);
    const bufView = new Uint8Array(buf);
    for (let i = 0, strLen = str.length; i < strLen; i++) {
        bufView[i] = str.charCodeAt(i);
    }
    return buf;
}


Note: I have removed the `window` prefix from `window.atob` and `window.crypto.subtle` as it's not necessary in a browser environment. If you're running this in a Node.js environment, you'll need to use a different method to convert base64 strings to binary.