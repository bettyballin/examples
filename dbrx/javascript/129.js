// Define signatureRawData variable
var signatureRawData = "Hello, World!";

// Create a new TextEncoder instance
var utf8 = new TextEncoder('utf-8');

// Encode the signatureRawData to bytes
var signatureRawDataBytes = utf8.encode(signatureRawData);

// Print the result to the console
console.log(signatureRawDataBytes);