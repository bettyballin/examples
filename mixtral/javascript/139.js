const express = require('express');
const session = require('express-session');
const path = require('path');
const Parse = require('parse');

const app = express();

app.use(
  session({
    secret: 'your_secret',
    resave: false,
    saveUninitialized: true
  })
);

// Verify Password Reset
app.get('/verifypasswordreset/:token', function (req, res) {
  req.session.token = req.params.token;

  Parse.Cloud.run('verifyPasswordReset', { token: req.params.token }, {
    success: function(user) {
      res.sendFile(path.join(__dirname, 'website', 'resetpassword.html'));
    },
    error: function(error) {
      console.error(error);
      res.status(500).send('Internal Server Error');
    }
  });
});

// Reset Password
app.post('/resetpassword', function (req, res) {
  const resetToken = req.session.token;

  if (!resetToken){
    return res.status(401).send('Unauthorized');
  }

  Parse.Cloud.run('updatePassword', { password: req.body.password, token: resetToken }, {
    success: function() {
      res.send('Password updated successfully');
    },
    error: function(error) {
      console.error(error);
      res.status(500).send('Internal Server Error');
    }
  });
});

app.listen(3000, function () {
  console.log('Server started on port 3000');
});