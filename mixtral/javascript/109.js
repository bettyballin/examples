var express = require('express');
var FirebaseTokenGenerator = require("firebase-token-generator");
var app = express();

// Import the token generator
const firebaseTokenGenerator = new FirebaseTokenGenerator("<YOUR_FIREBASE_SECRET>");

app.get('/token', function(req, res) {
  // Create a custom token
  var token = firebaseTokenGenerator.createToken({uid: "uniqueId1", some: "arbitrary", data: "here"});

  // Send it back to the client
  return res.json({token: token})
});

app.listen(3000, function() {
  console.log('Server listening on port 3000!');
});