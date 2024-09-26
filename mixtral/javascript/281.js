const express = require('express');
const app = express();
const port = 3000;

app.use(
  '/public',
  express.static(__dirname, {
    ignore: ['**/.*'] // This will exclude all hidden files and directories
  })
);

app.listen(port, () => {
  console.log(`Server running on port ${port}`);
});