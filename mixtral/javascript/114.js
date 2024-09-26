var ref = new Firebase($scope.firebaseurl+'/' + jsonArray.UserProfile.UID);

// Remove any active listeners
ref.off();

// Unauthenticate
ref.unauth(function() {
  // Optionally you can check if the user is logged out
  console.log('Logged Out');
});