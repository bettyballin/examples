// Assuming this is part of a class or object with refApp, uid, job, and application properties
class Application {
  constructor(refApp, uid, job, application) {
    this.refApp = refApp;
    this.uid = uid;
    this.job = job;
    this.application = application;
  }

  saveApplication() {
    this.refApp.child(this.uid).child(this.job.id).set(this.application);
  }
}

// Example usage:
const firebase = require("firebase/app");
require("firebase/database");

const firebaseConfig = {
  // Your Firebase configuration
};

firebase.initializeApp(firebaseConfig);

const refApp = firebase.database().ref("applications");
const uid = "someuserid";
const job = { id: "somejobid" };
const application = { /* application data */ };

const app = new Application(refApp, uid, job, application);
app.saveApplication();