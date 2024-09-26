const axios = require('axios');

axios.get(`https://${process.env.DATABASE_NAME}.firebaseio.com/users/ada/name.json?auth=${process.env.ID_TOKEN}`)
  .then(response => {
    console.log(response.data);
  })
  .catch(error => {
    console.error(error);
  });