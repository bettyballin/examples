const request = require('request');

function getGoogleCerts(kid, callback) {
    request({uri: 'https://www.googleapis.com/oauth2/v1/certs'}, function(err, response, body){
        if(err && response.statusCode !== 200) {
            err = err || "error while retrieving the google certs";
            console.log(err);
            callback(err, {})
        } else {
            var keys = JSON.parse(body);
            callback(null, keys[kid]);
        }
    });
}

// Test the function
getGoogleCerts('some_kid', function(err, cert) {
    if (err) {
        console.log(err);
    } else {
        console.log(cert);
    }
});