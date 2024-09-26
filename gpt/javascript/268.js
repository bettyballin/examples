
function getAuthHeader(httpMethod, requestUrl, requestBody) {
    var CLIENT_KEY = 'test';
    var SECRET_KEY = 'A93reRTUJHsCuQSHR+L3GxqOJyDmQpCgps102ciuabc=';

    var requestTimeStamp = "1521622403";
    var nonce  = "715de35a4bfd4912baaa16daef21992d";
    requestUrl = requestUrl.toLowerCase();

    var signatureRawData = CLIENT_KEY + requestUrl + requestTimeStamp + nonce;
    console.log("signatureRawData: " + signatureRawData);

    // Decode the Base64 secret key to a WordArray for CryptoJS
    var secretKeyByteArray = CryptoJS.enc.Base64.parse(SECRET
