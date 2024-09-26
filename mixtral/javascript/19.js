const express = require('express');
const app = express();
const MongoClient = require('mongodb').MongoClient;

// Connection URL
const url = 'mongodb://localhost:27017';

// Database Name
const dbName = 'mydatabase';

// Create a new MongoClient
MongoClient.connect(url, function(err, client) {
  if (err) {
    console.log(err);
  } else {
    console.log('Connected to database');
    const db = client.db(dbName);

    exports.postsQuery = function(req, res) {
      var query = req.params.query; // 'awesome'

      db.collection('products').find({ name: new RegExp('\\b' + query + '\\b', 'i') }).toArray(function(err, records) {
        if (err) {
          console.log(err);
          res.status(500).send({ message: 'Error fetching data' });
        } else {
          res.send(records);
        }
      });
    };

    app.get('/posts/:query', exports.postsQuery);

    app.listen(3000, function() {
      console.log('Server listening on port 3000');
    });
  }
});