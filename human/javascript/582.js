function S4() {
    return (((1+Math.random())*0x10000)|0).toString(16).substring(1); 
}

function GetNonce() {
    return (S4() + S4() + S4()+ S4() + S4() + S4() + S4()+ S4()).toLowerCase();
}

function GetTimeStamp() {
    var d = new Date();
    return Math.round(d.getTime() / 1000);
}

function getAuthHeader(httpMethod, requestUrl, requestBody) {
    var CLIENT_KEY = 'your_api_user';
    var SECRET_KEY = 'your_api_key';
    var AUTH_TYPE = 'HMAC';

    var requestTimeStamp = GetTimeStamp();
    var nonce = GetNonce();
    requestUrl = requestUrl.toLowerCase();

    var signatureRawData = [CLIENT_KEY,requestUrl,requestTimeStamp,nonce].join("");
    var key = CryptoJS.enc.Base64.parse(SECRET_KEY);

    var hash = CryptoJS.HmacSHA256(signatureRawData, key);
    var hashInBase64 = CryptoJS.enc.Base64.stringify(hash);

    var header = [CLIENT_KEY, hashInBase64, nonce, requestTimeStamp].join(":");
    console.log("header: "+ header);

    return AUTH_TYPE+" "+header;
}

var request = {
    'method': 'GET',
    'url': 'https://example.com/api/endpoint',
    'data': ''
};

var authHeader = getAuthHeader(request['method'], request['url'], request['data']);
console.log(authHeader);