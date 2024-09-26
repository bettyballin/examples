const express = require('express');
const mongoSanitize = require('express-mongo-sanitize');

const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.use(function (req, res, next) {
  req.body = mongoSanitize(req.body);
  // or
  var sanitizedCode = mongoSanitize(req.body);

  return next();
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});