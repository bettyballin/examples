const express = require('express');
const crypto = require('crypto');
const app = express();

// Load your secret key securely from environment variables or config files
let SECRET_KEY = process.env['SECRET_KEY'];

app.use(express.json());

app.post('/generate-signature', (req, res) => {
  let formFieldsString = JSON.stringify(req.body);

  // Generate hash using the provided algorithm
  const signature = crypto
    .createHash('md5')
    .update(formFieldsString + SECRET_KEY)
    .digest("hex");

  res.send({signature: signature});
})

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
})