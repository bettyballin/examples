const express = require('express');
const server = express();
const fs = require('fs');
const nacl = require('tweetnacl');
const github = require('octokit')();

// Get your key
let key;
if (process.env.ENCRYPTION_KEY) {
  // If ENCRYPTION_KEY is set as an environment variable
  const base64Key = process.env.ENCRYPTION_KEY
  key = nacl.util.decodeBase64(base64Key);
} else if (fs.existsSync('path/to/your-keyfile')) {
  // If you have a file containing your encryption keys
  const rawData = fs.readFileSync('path/to/your-keyfile');
  key = nacl.util.decodeBase64(rawData);
} else throw new Error("No decryption key found");

server.get('/fetchcryptmessagefromself/:id', (req, res) => {
  // Retrieve and decrypt the secret gist corresponding to the given ID
  const id = req.params.id;

  return github.gists.get({
    id
  })
  .then((response) => {
    // Assuming the gist contains a single file with the encrypted message
    const encryptedMessage = response.data.files['file.txt'].content;
    const decryptedMessage = nacl.secretbox.open(encryptedMessage, key);

    res.send(decryptedMessage.toString());
  })
  .catch((err) => {
    console.error(err);
    res.status(500).send('Error fetching or decrypting message');
  });
});

server.listen(3000, () => {
  console.log('Server listening on port 3000');
});