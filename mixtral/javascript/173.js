require('dotenv').config();
const request = require('request');

const API = 'https://api.example.com'; // replace with your API endpoint

request({
  uri: API,
  method: 'POST',
  json: true,
  form: {
    username: process.env.USERNAME,
    password: process.env.PASSWORD
  }
}, (error, response, body) => {
  if (error) {
    console.error(error);
  } else {
    console.log(body);
  }
});


`.env` file:

USERNAME=myusername
PASSWORD=mypassword


`.gitignore` file:

.env