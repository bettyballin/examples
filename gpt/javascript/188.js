
// Assuming you have injected $firebaseAuth into your controller/service
var auth = $firebaseAuth();

// Logout function
$scope.logout = function() {
    auth.$signOut().then(function() {
        console.log("Logged out successfully");
        // Perform any
