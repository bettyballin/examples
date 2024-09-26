const axios = require('axios');

axios.head('http://localhost:8080/user', {
  headers: {
    'X-Requested-With': 'XMLHttpRequest',
    Authorization: 'Basic dXNlcjpwYXNzd29yZA=='
  }
})
.then(response => {
  console.log(response.status);
  console.log(response.headers);
})
.catch(error => {
  console.error(error);
});