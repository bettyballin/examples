const firebase = require('firebase');

const config = {
  apiKey: '<API_KEY>',
  authDomain: '<AUTH_DOMAIN>',
  databaseURL: '<DATABASE_URL>',
  projectId: '<PROJECT_ID>',
  storageBucket: '<STORAGE_BUCKET>',
  messagingSenderId: '<MESSAGING_SENDER_ID>',
};

firebase.initializeApp(config);

const db = firebase.database();

const rules = {
  rules: {
    myPath: {
      $pushId: {
        '.write': true,
        '.validate': 'newData.hasChildren(["name", "email", "agreeTerms", "results"])',
        name: { '.validate': 'newData.isString() && newData.val().length < 100' },
        email: { '.validate': 'newData.isString()' },
        agreeTerms: { '.validate': 'newData.isString() && newData.val().length < 4' },
      },
    },
    '.read': 'auth != null',
    '.write': 'auth != null',
  },
};

db.ref('/').setRules(rules);