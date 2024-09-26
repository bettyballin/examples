// Import required libraries
var Firebase = require('firebase');
var angularFire = require('angularfire');

// Initialize Firebase
var config = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>'
};
Firebase.initializeApp(config);

// Set base URL and GROUP_ID
var base = 'https://<DATABASE_NAME>.firebaseio.com';
var GROUP_ID = '<GROUP_ID>';

// Create a Firebase reference
var ref = new Firebase(base + '/posts/' + GROUP_ID);

// Create a $firebaseArray object
var posts = angularFire.$firebaseArray(ref);