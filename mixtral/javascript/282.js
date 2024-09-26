const https = require('https');
const axios = require('axios');
const fs = require('fs');

const httpsAgent = new https.Agent({
  rejectUnauthorized: true,
  ca: [fs.readFileSync('path/to/ca-certificate')]
});

const urlToPrivateApiEndpoint = 'https://your-private-api-endpoint.com';

axios.get(urlToPrivateApiEndpoint, { httpsAgent })
  .then(response => console.log(response.data))
  .catch(error => console.error(error));