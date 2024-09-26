const axios = require('axios');

axios.head('http://localhost:8080/user', {
  headers: {
    'X-Requested-With': 'XMLHttpRequest'
  }
})
.then(response => {
  console.log(response.status);
  console.log(response.headers);
})
.catch(error => {
  console.log(error.response.status);
  console.log(error.response.headers);
});