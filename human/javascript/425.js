const express = require('express');
const app = express();
const path = require('path');
const bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

app.post('/passwordreset', function(req, res) {
  Parse.Cloud.run('verifyPasswordReset', { token: req.param("id") }, {
    success: function(user) {   
      //update user's password here
      user.set("password", req.body.password);
      user.save(null, {
        success: function(user) {
          res.send('Password reset successful!');
        },
        error: function(user, error) {
          res.sendFile(path.join(__dirname + '/website/error.html'));
        }
      });
    },
    error: function(error) {
      res.sendFile(path.join(__dirname + '/website/error.html'));
    }
  });
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});