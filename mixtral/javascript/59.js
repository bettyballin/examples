app.config(['$httpProvider', function ($httpProvider) {
   //Http Interceptor to check auth failures for xhr requests
  $httpProvider.interceptors.push('myHttpInterceptor');
}]);