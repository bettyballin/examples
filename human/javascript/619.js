function stringToArrayBuffer(str) {
    var encoder = new TextEncoder('utf-8');
    return encoder.encode(str);
}

function convertArrayBufferToHexaDecimal(buffer) {
    var data_view = new DataView(buffer)
    var iii, len, hex = '', c;

    for(iii = 0, len = data_view.byteLength; iii < len; iii += 1) 
    {
        c = data_view.getUint8(iii).toString(16);
        if(c.length < 2) 
        {
            c = '0' + c;
        }

        hex += c;
    }

    return hex;
}

var mnemonic = "your_mnemonic_here";
var passphrase = "your_passphrase_here";

window.crypto.subtle.importKey(
    'raw',
    stringToArrayBuffer(mnemonic),
    {
        name: 'PBKDF2',
    },
    false,
    ['deriveKey']
).then((importedKey) => {

    window.crypto.subtle.deriveKey({
            name: "PBKDF2",
            salt: stringToArrayBuffer('mnemonic'+passphrase),
            iterations: 2048,
            hash: { name: 'SHA-512' }
        }, 
        importedKey,
        {
            name: 'HMAC',
            hash: 'SHA-512',
            length: 512
        },
        true,
        ['sign']
    ).then(function(derivedKey) {

        window.crypto.subtle.exportKey('raw',derivedKey).then((exportedKey) => {
            console.log(convertArrayBufferToHexaDecimal(exportedKey));
        });

    });
})