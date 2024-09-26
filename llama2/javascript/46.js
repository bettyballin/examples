const express = require('express');
const MongoClient = require('mongodb').MongoClient;
const app = express();
app.use(express.json());

// Replace with your MongoDB connection string
const mongoUrl = 'mongodb://localhost:27017';

// Replace with your MongoDB database and collection names
const dbName = 'myDatabase';
const collectionName = 'myCollection';

MongoClient.connect(mongoUrl, function(err, client) {
  if (err) {
    console.log(err);
  } else {
    console.log('Connected to MongoDB');
    const db = client.db(dbName);
    const collection = db.collection(collectionName);

    app.post('/postResults', function(req, res) {
      collection.aggregate([
        {
          $match: {
            $expr: {
              $and: [
                { $eq: ["$district", req.body.district] }
                // Add more match criteria as needed
              ]
            }
          }
        },
        {
          $group: {
            _id: "$district",
            count: {$sum: 1}
          }
        }
      ], function(err, docs) {
        console.log(docs);
        res.render('postResults', {
          "output" : docs
        });
      });
    });

    app.listen(3000, function() {
      console.log('Server listening on port 3000');
    });
  }
});