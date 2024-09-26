import firebase from 'firebase/app';
import 'firebase/database';

// Initialize Firebase
var config = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: 'https://crackling-fire-1105.firebaseio.com',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>'
};
firebase.initializeApp(config);

var ref = firebase.database().ref('business');
ref.orderByChild('city').equalTo('Pétion-Ville').on('child_added', function(snapshot) {
  console.log(snapshot.val());
});