const url = require('url');

const requestUrl = 'http://example.com/api/users'; // replace with your request URL

const parsedUrl = url.parse(requestUrl);

if (parsedUrl.pathname.match(/^\/api/)) {
  console.log('Checking RestSecurityConfig configuration...');
  // code to check RestSecurityConfig configuration
} else {
  console.log('Checking WebSecurityConfig configuration...');
  // code to check WebSecurityConfig configuration
}