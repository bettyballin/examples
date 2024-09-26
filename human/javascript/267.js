// Import the required libraries
const WL = require('worklight');

// Define the collections and options
var collections = {
  users : {
    searchFields : {'userid' : 'integer'}
  }
};

var options = {
  password: '123'
};

// Initialize the JSONStore
WL.JSONStore.init(collections, options)
.then(function () {
  // Add a new user to the collection
  return WL.JSONStore.get('users').add({userid: 50005});
})
.then(function () {
  // Find all users in the collection
  return WL.JSONStore.get('users').findAll();
})
.then(function (results) {
  // Log the results
  console.debug(results);
})
.fail(function (error) {
  // Handle failure in any of the API calls above
  console.error(error);
});