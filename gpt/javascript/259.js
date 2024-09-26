
const firebase = require('firebase');
// Firebase client SDK configuration
const firebaseConfig = {
    apiKey: "...", // Your API Key
    authDomain: "...", // Your Auth Domain
    projectId: "...", // Your Project ID
    // other config
};

// Initialize Firebase App
if (!firebase.apps.length) {
    firebase.initializeApp(firebaseConfig);
} else {
    firebase.app(); // if already initialized, use that one
}

const db = firebase.firestore();

