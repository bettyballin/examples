const itemName = "example";
const itemQuantity = 10;

const item = {
  _id: 10,
  item: "$" + itemName,
  qty: itemQuantity
};

console.log(item);

// Node.js MongoDB driver example
const { MongoClient } = require("mongodb");
const url = "mongodb://localhost:27017";
const dbName = "mydatabase";

MongoClient.connect(url, function(err, client) {
  if (err) {
    console.log(err);
  } else {
    console.log("Connected to database");
    const db = client.db(dbName);
    db.collection("products").insertOne(item, function(err, result) {
      if (err) {
        console.log(err);
      } else {
        console.log("Document inserted");
        client.close();
      }
    });
  }
});