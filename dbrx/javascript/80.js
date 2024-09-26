const { ObjectID } = require('mongodb');
const express = require('express');
const app = express();
const mongoose = require('mongoose');

mongoose.connect('mongodb://localhost:27017/mydatabase', { useNewUrlParser: true, useUnifiedTopology: true });

const postSchema = new mongoose.Schema({
  userID: ObjectID
});

const Posts = mongoose.model('Posts', postSchema);

function decrypt(id) {
  // implement your decryption logic here
  return id;
}

app.get('/:id', (req, res) => {
  var x = decrypt(req.params.id);
  x = new ObjectID(x);

  Posts.findOne({ userID: x }, function(err, post) {
    if (err) {
      res.status(500).send(err);
    } else {
      res.send(post);
    }
  });
});

app.listen(3000, () => {
  console.log('Server listening on port 3000');
});