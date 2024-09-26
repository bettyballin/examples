const CryptoJS = require("crypto-js");

const IV_MESSAGE = "a";
const API_SECRET = "secret_key\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0\0";

function encrypt(stringData){
    const iv = CryptoJS.SHA256(IV_MESSAGE).toString(CryptoJS.enc.Hex).substring(0, 16);
    const encrypted = CryptoJS.AES.encrypt(
        stringData, 
        CryptoJS.enc.Utf8.parse(API_SECRET), 
        {
            iv: CryptoJS.enc.Utf8.parse(iv)
        });

    return encrypted;
};

const stringData = {"uid":19,"price":10000000,"duration":240,"credit_purpose":5,"new_tab":false,"cssFile":"kalkulatorok","css":[],"supported":false,"email":"test@test.hu","productType":"home_loan","method":"calculator","calculatorType":"calculator","unique":true};
const ciphertextB64 = encrypt(JSON.stringify(stringData)).toString();

console.log(ciphertextB64.replace(/(.{64})/g,'$1\n'));