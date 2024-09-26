// Initialize the app with a custom auth variable, limiting the server's access
var firebase = require("firebase-admin");

firebase.initializeApp({
  databaseURL: "https://databaseName.firebaseio.com",
  credential: firebase.credential.cert(require("path/to/serviceAccountCredentials.json")),
  databaseAuthVariableOverride: {
    uid: "my-service-worker"
  }
});