// Define the myapp module
var myapp = angular.module('myapp', []);

// Define the myHttpResponseInterceptor factory
myapp.factory('myHttpResponseInterceptor',['$q','$location',function($q,$location){
  return {
    response: function(response){
      return response;
    },
    responseError: function(response){
      if(response.status === 401){
        $location.path('/signin');
        return $q.reject(response);
      }
      else{
        return $q.reject(response); 
      }
    }
  }
}]);

// Define the config block to add the interceptor to $httpProvider
myapp.config(['$httpProvider',function($httpProvider) {
  $httpProvider.interceptors.push('myHttpResponseInterceptor');
}]);