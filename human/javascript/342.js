angular.module('myApp', ['firebase'])
  .run(['$rootScope', '$firebaseAuth', function($rootScope, $firebaseAuth) {
    var auth = $firebaseAuth();
    $rootScope.$auth = auth;
    auth.$onAuthStateChanged(function(authData){
      $rootScope.authData = authData;
      $rootScope.$apply();
    });
  }]);