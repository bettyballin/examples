let _n = 15;
let _end = null;

// Initialize Firebase
var config = {
  apiKey: "<API_KEY>",
  authDomain: "<AUTH_DOMAIN>",
  databaseURL: "<DATABASE_URL>",
  projectId: "<PROJECT_ID>",
  storageBucket: "<STORAGE_BUCKET>",
  messagingSenderId: "<MESSAGING_SENDER_ID>"
};
firebase.initializeApp(config);

function lazyLoadItems() {
  firebase.database().ref('items')
    .orderByChild('timestamp') // Use 'title' if you don't have a unique key like 'timestamp'
    .startAt(_end) // Start at the last loaded item's timestamp (or title)
    .limitToFirst(_n)
    .on("child_added", snapshot => {
      console.log(snapshot.val());
      
      _end = snapshot.child('timestamp').val(); // Update '_end' with new end value
    });
}

// Call the function to start loading items
lazyLoadItems();