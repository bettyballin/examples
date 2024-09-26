// Import Firebase library
import firebase from 'firebase/app';
import 'firebase/database';

// Initialize Firebase
firebase.initializeApp({
  // Your Firebase project configuration
});

// Set base URL of Firebase Realtime Database
const base = 'https://your-project-id.firebaseio.com';

// Set USER_ID variable
const USER_ID = 'your-user-id';

// Create Firebase Realtime Database reference
const fb = firebase.database().ref(base);

// Create NormalizedCollection reference
const ref = firebase.utils.NormalizedCollection(
  fb.child('posts_i_can_view/' + USER_ID),
  fb.child('posts')
)
.select('posts.message', 'posts.user_id')
.ref();

// Create $firebaseArray instance
const posts = $firebaseArray(ref);

// Print the posts array
console.log(posts);