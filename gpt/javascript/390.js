
const express = require('express');
const crypto = require('crypto');
const app = express();
const port = 3000;

// Token storage (in-memory for this example)
let tokens = {};

app.get('/api/video/:videoId', (req, res) => {
  const { token } = req.query;
  const { videoId } = req.params;

  // Verify if the token is valid and has not expired
  if (tokens[token]
