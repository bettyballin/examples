const express = require('express');
const app = express();

app.use(express.json());

const database = {
  saveBlogpost: (blogpost) => {
    console.log('Saving blog post:', blogpost);
    // Replace with actual database logic
  }
};

app.post('/api/save', (req, res) => {
  if (req.user && req.user.userId === 'bergur') {
    database.saveBlogpost(req.body);
    res.sendStatus(200);
  } else {
    res.sendStatus(401);
  }
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});