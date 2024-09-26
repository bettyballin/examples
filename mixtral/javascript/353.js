const express = require('express');
const redis = require('redis');
const rateLimit = require('express-rate-limit');

// Create a Redis client
const redisClient = redis.createClient({
  host: 'localhost',
  port: 6379
});

// Create an Express app
const app = express();

app.use(
  rateLimit({
    windowMs: 60 * 1000,
    max: 10
  })
);

// Function to generate a unique token
function generateUniqueToken() {
  return Math.random().toString(36).substr(2) + Math.random().toString(36).substr(2);
}

// Function to validate a token
async function validateToken(token) {
  // Token validation logic here
  // For example, check if token is not expired
  return true; // Replace with actual validation logic
}

app.get('/video/:id', async (req, res) => {
  const videoId = req.params.id;

  // Generate a unique token for this request
  let token = await new Promise((resolve, reject) => {
    redisClient.hget('tokens', `token:${videoId}`, (err, reply) => {
      if (err) reject(err);
      resolve(reply);
    });
  });

  if (!token || !await validateToken(token)) {
    res.status(403).send({ error: 'Invalid or expired access' });

    // Generate a new unique token
    const newToken = generateUniqueToken();

    await new Promise((resolve, reject) => {
      redisClient.hset('tokens', `token:${videoId}`, newToken, (err, reply) => {
        if (err) reject(err);
        resolve(reply);
      });
    });

    res.json({
      video_url: `${process.env.API_URL}/videos/${videoId}/${newToken}`
    });
  } else {
    // Token already exists return null response
    res.json(null);
  }
});

// Start the server
const port = 3000;
app.listen(port, () => {
  console.log(`Server started on port ${port}`);
});