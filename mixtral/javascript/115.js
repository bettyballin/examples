app.factory('FirebaseService', function($firebase, $q) {
  var ref = new Firebase('<your-firebase-url>');
  var currentUserId;

  // Store references
  var userRef;

  return {
    getUserReference: function(userId) {
      if (userRef && userId === currentUserId)
        return $q.when(userRef);

      currentUserId = userId;

      userRef = ref.child('users/' + userId);

      // Return a promise that resolves with the reference
      var deferred = $q.defer();

      setTimeout(function() {
        deferred.resolve(userRef);
      }, 0);

      return deferred.promise;
    },

    logout: function (){
       // Remove any active listeners
       userRef && userRef.off();

       ref.unauth();

     }

   };
});