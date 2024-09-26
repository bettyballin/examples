// Assuming you are using Firebase Realtime Database
import firebase from 'firebase/app';
import 'firebase/database';

// Initialize Firebase
firebase.initializeApp({
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
});

// Create a reference to the database
const db = firebase.database();

class JobApplication {
  constructor(uid, job, application) {
    this.uid = uid;
    this.job = job;
    this.application = application;
  }

  apply() {
    const refApp = db.ref('applications');
    refApp.child(this.uid).child(this.job.id).set({
      [this.job.id]: this.application,
    });
  }
}

// Example usage
const job = { id: 'job123' };
const application = { message: 'I am excited about this opportunity!' };
const uid = 'user123';

const jobApplication = new JobApplication(uid, job, application);
jobApplication.apply();