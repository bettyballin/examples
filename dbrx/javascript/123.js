const fs = require('fs');
const Forge = require('node-forge');
const XAdES = require('xadesjs');

// Read the private key from PEM file
let privateKeyPem = fs.readFileSync("key.pem").toString();

// Convert it to PKCS8 format using node-forge library
let pki = Forge.pki;
let privateKeyDer = pki.privateKeyToAsn1(pki.privateKeyFromPem(privateKeyPem));
let privateKeyPkcs8 = new Uint8Array(Forge.asn1.toDer(privateKeyDer).getBytes());

// Import the PKCS8 key using xadesjs
XAdES.Application.crypto.subtle.importKey("pkcs8", privateKeyPkcs8, {
    name: "RSASSA-PKCS1-v1_5",
    modulusLength: 2048,
    publicExponent: new Uint8Array([0x01, 0x00, 0x01]),
    hash: { name: "SHA-256" }
}, false, ["sign"])
.then(function(privateKey) {
    let xmlString = "<your_xml_string_here>";
    // Call sign function
    return XAdES.SignXml(xmlString, privateKey, {
        name: "RSASSA-PKCS1-v1_5",
        hash: { name: "SHA-256" }
    });
})
.then(function(signedXml) {
    console.log(signedXml);
})
.catch(function(err) {
    console.error(err);
});