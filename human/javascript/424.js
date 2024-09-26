const express = require('express');
const path = require('path');
const app = express();

app.get('/passwordreset', function(req, res) {
      res.sendFile(path.join(__dirname + '/website/resetpassword.html'));
});

app.listen(3000, function () {
  console.log('Server is running on port 3000');
});