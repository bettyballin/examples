app.config(['$httpProvider', function($httpProvider){
    $httpProvider.defaults.headers.common['Authorization'] = 'Basic <base64-encoded username:password>';
}]);