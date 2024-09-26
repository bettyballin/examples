firebase.auth().onAuthStateChanged(function(user) {
  if (user) {
    // User is signed in. Now we can use the user object directly.
    var username = user.displayName;
    var providerId = user.providerData[0].providerId;

    // Send XMLHttpRequest with 'username' and 'providerId'.
    var xhr = new XMLHttpRequest();
    xhr.open('POST', '/your-endpoint', true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(JSON.stringify({username: username, providerId: providerId}));
  } else {
    // User is not authenticated redirect to login page or show a message
    window.location.href = '/login';
  }
});