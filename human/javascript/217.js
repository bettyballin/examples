// Define the loadCert function
function loadCert(certname) {
    // Return a sample certificate object
    return {
        sig: "sample_signature"
    };
}

// Define the log function
function log(message) {
    console.log(message);
}

// Define the verifyCertificate function
function verifyCertificate(signedCert, certname) {
    var loadedCert = loadCert(certname);

    var originalSig = JSON.stringify(signedCert.sig);
    var loadedSig = JSON.stringify(loadedCert.sig);
    log(loadedSig);
    return (originalSig == loadedSig);
}

// Test the verifyCertificate function
var signedCert = {
    sig: "sample_signature"
};
var certname = "sample_cert";
console.log(verifyCertificate(signedCert, certname));