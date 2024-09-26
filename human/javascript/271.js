angular.module('yourApp')
.factory('responseObserver', function responseObserver($q, $window) {
    return {
        'responseError': function(errorResponse) {
            switch (errorResponse.status) {
            case 403:
                $window.location = './403.html';
                break;
            case 500:
                $window.location = './500.html';
                break;
            }
            return $q.reject(errorResponse);
        }
    };
});

angular.module('yourApp').config(['$httpProvider', function($httpProvider) {
    $httpProvider.interceptors.push('responseObserver');
}]);