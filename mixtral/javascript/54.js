var fbRef = new Firebase('https://fbKey.firebaseIO.com/buttonClicksByBrowsersession');

// Store the creation time
var createdAt = Firebase.ServerValue.TIMESTAMP;

button.addEventListener('click', function() {
  // Create a child with current timestamp
  var numClicksRef = fbRef.push({
    "createdAt": createdAt
  });

  // Increment the number of clicks
  numClicksRef.transaction(function(current_value) {
    return (current_value || 0) + 1;
  }, function() {}, false);
});