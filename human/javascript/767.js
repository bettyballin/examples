const express = require('express');
const app = express();

app.use([/^\/public\/secure($|\/)/, /(.*)\.js\.map$/, '/public'], express.static(__dirname + '/public'));

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});