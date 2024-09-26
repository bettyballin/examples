const express = require('express');
const app = express();

app.get('/first',function(req,res){
  res.send('Hello from /first');
})

// middleware to filter calls
app.use(function(req,res,next){
  var ipOfSource = req.connection.remoteAddress;
  if(ipOfSource == '127.0.0.1' || ipOfSource == '::1') next();
  else res.send('Access denied');
})

// all routes which need to be accessed from localhost goes here.
app.get('/will-be-accessible-from-localhost',function(req,res){
  res.send('Hello from /will-be-accessible-from-localhost');
})

app.listen(3000, function () {
  console.log('Example app listening on port 3000!');
})