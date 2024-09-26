app.config(['$httpProvider', function($httpProvider) {
    //initialize get if not there
    if (!$httpProvider.defaults.headers.get) {
        $httpProvider.defaults.headers.get = {};
    }

    // Answer set to true so Angular strips the X-Requested-With header from requests.
    $httpProvider.defaults.headers.get['If-Modified-Since'] = '0';

}]);