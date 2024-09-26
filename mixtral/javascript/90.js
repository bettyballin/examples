$scope.login = function() {
  // Call the login service
  LoginService.authenticateUser({
    email: $scope.email,
    password: $scope.password
  }).then(function successCallback(response) {
      if (response && response.data && !response.data.errorMessage) {
        // Clear the sensitive data
        delete $scope.password;

        // Redirect to dashboard or home page
        $location.path('/dashboard'); // assuming you're using AngularJS routing

      } else {
         console.log('Login failed');
       }
  }, function errorCallback(response) {
    console.log('Error occurred during login:', response);
  });
};