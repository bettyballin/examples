script
const firebase = require("firebase");
const util = require('util');

var firebaseConfig = {
   apiKey: "<redacted>",
   authDomain: "<redacted>",
   databaseURL: "<redacted>",
   projectId: "<redacted>",
   storageBucket: "<redacted>",
   messagingSenderId: "<redacted>",
   appId: "<redacted>",
};

firebase.initializeApp(firebaseConfig);
var database = firebase.firestore();

["<redacted>", "<redacted>"].forEach(collection => {
   database.collection(collection).get().then(function(querySnapshot) {
       console.log(`Data for ${collection}:`);
       querySnapshot.forEach((doc) => {
           var data = doc.data();
           console.log(util.inspect(data, false, null, true));
       });
   }).catch(function (error) {
       console.log("Error getting document:", error);
   });
});