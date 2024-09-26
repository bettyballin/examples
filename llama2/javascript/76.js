const secureai = require("secure-ai");
const fs = require("fs");

let key = fs.readFileSync("key.pem", "utf8");

secureai.importKey(key)
    .then((privateKey) => {
        console.log("Private Key:", privateKey);

        let cert = fs.readFileSync("cert.pem", "utf8");

        secureai.importCertificate(cert)
            .then((certificate) => {
                console.log("Certificate:", certificate);

                // Assuming xmlString is defined somewhere
                let xmlString = "<your_xml_string_here>";

                // Call sign function
                return secureai.SignXml(xmlString, privateKey, 
                    { name: "RSASSA-PKCS1-v1_5", hash: { name: "SHA-256" } });
            })
            .then((signedXml) => {
                console.log("Signed Xml:", signedXml);
            })
            .catch((err) => {
                console.error(err);
            });
    })
    .catch((err) => {
        console.error(err);
    });