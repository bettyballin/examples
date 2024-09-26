const express = require('express');
const jwt = require('jsonwebtoken');

const app = express();

const verifyToken = (token) => {
  const secretKey = 'your-secret-key';
  return jwt.verify(token, secretKey);
};

const adminOnlyFunction = () => {
  console.log('Admin only function executed');
};

app.get('/protected', (req, res) => {
  const jwtToken = req.header('Authorization');

  try {
    const payload = verifyToken(jwtToken);
    if (payload.roles.includes("ADMIN")) {
      adminOnlyFunction();
      return res.status(200).send();
    } else {
      return res.status(403).send();
    }
  } catch (err) {
    return res.status(401).send();
  }
});

app.listen(3000, () => {
  console.log('Server started on port 3000');
});