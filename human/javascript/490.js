// Import KJUR library
const KJUR = require('jsrsasign');

// Set secret key
const secret = "your_secret_key_here";

// Header
var oHeader = { alg: 'HS256', typ: 'JWT' };

// Payload
var oPayload = {};
var tNow = KJUR.jws.IntDate.get('now');
var tEnd = KJUR.jws.IntDate.get('now + 1day');
oPayload.iss = "http://foobar.com";
oPayload.sub = "mailto:someone@hello.com";
oPayload.iat = tNow;
oPayload.exp = tEnd;
oPayload.jti = "id123";
oPayload.aud = "http://someUrl";
oPayload.email = "userEmail";
oPayload.pwd = "userPassword";
oPayload.deviceId = "deviceId";

// Sign JWT.
var sHeader = JSON.stringify(oHeader);
var sPayload = JSON.stringify(oPayload);
var sJWT = KJUR.jws.JWS.sign("HS256", sHeader, sPayload, secret);
console.log(sJWT);