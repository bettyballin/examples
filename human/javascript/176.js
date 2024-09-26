const googleIdToken = require('google-id-token');

// Sample Google ID token (replace with your own token)
const sampleGoogleIDToken = "YOUR_GOOGLE_ID_TOKEN_HERE";

// Function to retrieve Google's public certificates
function getGoogleCerts(kid, callback) {
  const https = require('https');
  https.get("https://www.googleapis.com/oauth2/v1/certs", (res) => {
    let certificates = '';
    res.on('data', (d) => {
      certificates += d;
    });
    res.on('end', () => {
      callback(null, JSON.parse(certificates)[kid]);
    });
  }).on('error', (e) => {
    callback(e);
  });
}

const parser = new googleIdToken({ getKeys: getGoogleCerts });
parser.decode(sampleGoogleIDToken, function(err, token) {
  if(err) {
    console.log("error while parsing the google token: " + err);
  } else {
    console.log("parsed id_token is:\n" + JSON.stringify(token));
  }
});