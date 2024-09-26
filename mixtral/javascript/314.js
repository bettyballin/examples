const { contextBridge } = require('electron');
const firebase = require('firebase/app');

// Initialize firebase
var config = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>',
};
firebase.initializeApp(config);

contextBridge.exposeInMainWorld("firebase", firebase);