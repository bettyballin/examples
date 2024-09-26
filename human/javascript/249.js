const express = require('express');
const app = express();

app.get('/posts/:post_id/data', (req, res) => {
  const postId = req.params.post_id;
  // Your logic here
  res.send(`Post ID: ${postId}`);
});

app.get('/posts_i_can_view/:user_id/:post_id/true', (req, res) => {
  const userId = req.params.user_id;
  const postId = req.params.post_id;
  // Your logic here
  res.send(`User ID: ${userId}, Post ID: ${postId}`);
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});