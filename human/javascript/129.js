const express = require('express');
const app = express();

app.use(express.json());

app.get('/api/data', (req, res) => {
  res.json({ message: 'Hello from server!' });
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});

// Client-side code
fetch('/api/data')
  .then(response => response.json())
  .then(data => console.log(data))
  .catch(error => console.error(error));