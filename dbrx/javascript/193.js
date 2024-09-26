const express = require('express');
const app = express();
const path = require('path');

// Serve static assets normally
app.use(express.static(path.join(__dirname, 'public')));

// Middleware function to block access to .git folder and its contents
function blockGit(req, res, next) {
  const gitPathRegex = /(\\.git|\\/\\.git)/;
  if (req.path.match(gitPathRegex)) {
    return res.status(403).send('Forbidden');
  }
  next();
}

// Use the middleware function for all requests
app.use(blockGit);

// Start server as usual
const port = process.env.PORT || 3000;
app.listen(port, () => console.log(`Server started on port ${port}`));