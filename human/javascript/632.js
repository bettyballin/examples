const axios = require('axios');

const source = 'http://jumanjipets.co.uk/wp-content/uploads/2018/02/koi.jpg';

axios.get(source, { responseType: 'arraybuffer' })
  .then(response => {
    const base64 = Buffer.from(response.data, 'binary').toString('base64');
    console.log(`<img src='data:image/jpeg;base64, ${base64}' />`);
  })
  .catch(error => console.error(error));