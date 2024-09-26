
var CryptoJS = require("crypto-js");

const d = new Date();
const timestamp = d.getTime();
const postData = {};
postData.nonce = 100; //timestamp * 1000; //nanosecond
postman.setEnvironmentVariable('nonce', postData.nonce);

const secret = CryptoJS.enc.Base64.parse(pm.environment.get("apiSecret"));
const path = pm.globals.get("balanceMethod");

// Ensure postData is converted into a string properly (e.g., query string format or JSON)
// For simplicity, I'm assuming you need a query string format similar to the Node.js reference
const messageString = "nonce=" + postData.nonce; // or use JSON.stringify(postData) if needed

//
