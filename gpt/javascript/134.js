
// Inject $firebaseAuth into your service or controller
app.service('AuthenticationService', function($firebaseAuth) {
    var authService = $firebaseAuth();

    return {
        removeUser: function(email, password) {
            var user = firebase.auth().currentUser;
            
            // Reauthenticate the user with their credentials
            var credential = firebase.auth.EmailAuthProvider.credential(email, password);
            user.reauthenticateWithCredential(credential).then(function() {
                // User re-authenticated. Now delete them
