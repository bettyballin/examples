// Import required libraries
const CryptoJS = require("crypto-js");
const moment = require("moment");

function getPasswordHash(test){

    // Generate nonce
    var nonceWA = !test ? CryptoJS.lib.WordArray.random(32) : CryptoJS.enc.Utf8.parse('55d61876-f882-42f0-b390-dc662a7e7279'); 
    console.log('nonce (Base64):  ' + nonceWA.toString(CryptoJS.enc.Base64)); 

    // Generate created
    var created = !test ? moment().utc().format('YYYY-MM-DDTHH:mm:ss[Z]') : '2021-01-21T18:19:32Z'; 
    var createdWA = CryptoJS.enc.Utf8.parse(created);
    console.log('created:         ' + created); 

    // Hash password
    var pwd = 'SECRETPASSWORD';
    var pwdHashWA =  CryptoJS.SHA1(pwd);

    // Hash nonce + created + pwd
    var passwordHash =  CryptoJS.SHA1(nonceWA.concat(createdWA).concat(pwdHashWA)).toString(CryptoJS.enc.Base64);

    console.log('passwordHash:    ' + passwordHash);
}

getPasswordHash(true);    // with testdata
getPasswordHash(false);   // without testdata