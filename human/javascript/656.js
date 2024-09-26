const express = require('express');
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get('/api/sendsecret', (req, res) => {
  if (req.user && req.user.isAdmin) {
    res.send('the big secret');
  } else {
    res.sendStatus(401); // Unauthorized
  }
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});