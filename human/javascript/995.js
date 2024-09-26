// Import the required modules
const { initializeApp } = require('firebase/app');
const { getStorage, uploadBytes, ref } = require('firebase/storage');

// Initialize Firebase
const firebaseConfig = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>',
  appId: '<APP_ID>',
};

const app = initializeApp(firebaseConfig);

// Get a reference to the storage bucket
const storage = getStorage(app);
const storageRef = ref(storage, 'path/to/file');

// Define the metadata and file
const metadata = { customMetadata: { isAuthed: true } };
const file = new File(['file contents'], 'file.txt', { type: 'text/plain' });

// Upload the file
const uploadTask = uploadBytes(storageRef, file, metadata);

// Log the result
uploadTask.then((snapshot) => {
  console.log('Uploaded a blob or file!');
});