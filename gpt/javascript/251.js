
const request = require('request');

const API = 'your-api-endpoint';
request({
    uri: API,
    method: 'POST',
    json: true,
    form: {
      'username': process.env.USERNAME, // Using environment variables
      'password': process.env.PASSWORD  // Using environment variables
    }
    // ... other request options
}, function(error, response, body) {
    // Handle response
});

